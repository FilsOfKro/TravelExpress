package com.lemolas.travelexpress.api.service.routes;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lemolas.travelexpress.api.model.airports.Airport;
import com.lemolas.travelexpress.api.model.airports.AirportsRequest;
import com.lemolas.travelexpress.api.model.airports.exception.MissingAirportInformationException;
import com.lemolas.travelexpress.api.model.routes.Route;
import com.lemolas.travelexpress.api.model.routes.RoutesRequest;
import com.lemolas.travelexpress.api.service.airports.AirportService;
import com.lemolas.travelexpress.utils.math.EarthUtils;

@Service
public class RoutesService {

	private Logger log = LoggerFactory.getLogger(AirportService.class);

	protected static final String apiPath = "routes";

	private RestTemplate restTemplate;

	private String apiUrl;

	private String apiKey;

	private AirportService airportService;

	private EarthUtils earthUtils;

	@Autowired
	public RoutesService(RestTemplate restTemplate, @Value("${travelexpress.flight.api.url}") String apiUrl,
			@Value("${travelexpress.flight.api.key}") String apiKey, AirportService airportService,
			EarthUtils earthUtils) {
		this.restTemplate = restTemplate;
		this.apiUrl = apiUrl;
		this.apiKey = apiKey;
		this.airportService = airportService;
		this.earthUtils = earthUtils;
	}

	@Cacheable(value = "defaultCache")
	public List<Route> getRoutes(RoutesRequest request) {
		String finalUrl = apiUrl + apiPath + "?key={key}&departureIcao={departureAirportId}&arrivalIcao={arrivalIcao}";

		log.info("About to call {} with apiKey {} and departure {} and arrival {}", finalUrl, apiKey,
				request.getDepartureAirportId(), request.getArrivalAirportId());

		ParameterizedTypeReference<List<Route>> listRouteType = new ParameterizedTypeReference<List<Route>>() {
		};

		List<Route> response = restTemplate.exchange(finalUrl, HttpMethod.GET, null, listRouteType, apiKey,
				request.getDepartureAirportId(), request.getArrivalAirportId()).getBody();

		return response;
	}

	@Cacheable(value = "defaultCache")
	public Double computeDistance(Route route) throws MissingAirportInformationException {
		String iataDepart = route.getDepartureIata();
		String icaoDepart = route.getDepartureIcao();
		String iataArrivee = route.getArrivalIata();
		String icaoArrivee = route.getArrivalIcao();

		Optional<Airport> departResponse = airportService.getAirport(new AirportsRequest(iataDepart, icaoDepart));

		if (departResponse.isPresent()) {
			Optional<Airport> arriveeResponse = airportService
					.getAirport(new AirportsRequest(iataArrivee, icaoArrivee));

			if (arriveeResponse.isPresent()) {
				Airport depart = departResponse.get();
				Airport arrivee = arriveeResponse.get();

				Double latA = Double.parseDouble(depart.getLatitudeAirport());
				Double lonA = Double.parseDouble(depart.getLongitudeAirport());
				Double latB = Double.parseDouble(arrivee.getLatitudeAirport());
				Double lonB = Double.parseDouble(arrivee.getLongitudeAirport());

				Double distance = earthUtils.computeDistance(latA, lonA, latB, lonB);
				return distance;
			} else {
				throw new MissingAirportInformationException(icaoArrivee);
			}
		} else {
			throw new MissingAirportInformationException(icaoDepart);
		}
	}
}
