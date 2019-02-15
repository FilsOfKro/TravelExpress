package com.lemolas.travelexpress.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lemolas.travelexpress.api.model.airports.Airport;
import com.lemolas.travelexpress.api.model.airports.AirportsRequest;
import com.lemolas.travelexpress.api.model.routes.Route;
import com.lemolas.travelexpress.api.model.routes.RoutesRequest;
import com.lemolas.travelexpress.utils.math.EarthUtils;

@RestController
@RequestMapping(RoutesController.apiPath)
@Component
public class RoutesController {

	private Logger log = LoggerFactory.getLogger(RoutesController.class);

	protected static final String apiPath = "routes";

	private RestTemplate restTemplate;

	private String apiUrl;

	private String apiKey;

	private AirportsController airportsController;

	private EarthUtils earthUtils;

	@Autowired
	public RoutesController(RestTemplate restTemplate, @Value("${travelexpress.flight.api.url}") String apiUrl,
			@Value("${travelexpress.flight.api.key}") String apiKey, AirportsController airportsController,
			EarthUtils earthUtils) {
		this.restTemplate = restTemplate;
		this.apiUrl = apiUrl;
		this.apiKey = apiKey;
		this.airportsController = airportsController;
		this.earthUtils = earthUtils;
	}

	@GetMapping
	public ResponseEntity<?> getRoutesByAirports(RoutesRequest request) {
		String finalUrl = apiUrl + apiPath
				+ "?key={key}&departureIcao={departureAirportId}&arrivalIcao={departureAirportId}";

		log.info("About to call {} with apiKey {} and departure {} and arrival {}", finalUrl, apiKey,
				request.getDepartureAirportId(), request.getArrivalAirportId());

		try {
			ParameterizedTypeReference<List<Route>> listRouteType = new ParameterizedTypeReference<List<Route>>() {
			};
			List<Route> response = restTemplate.exchange(finalUrl, HttpMethod.GET, null, listRouteType, apiKey,
					request.getDepartureAirportId(), request.getArrivalAirportId()).getBody();

			if (response != null) {

				if (!response.isEmpty()) {
					Route route = response.get(0);
					String iataDepart = route.getDepartureIata();
					String icaoDepart = route.getDepartureIcao();
					String iataArrivee = route.getArrivalIata();
					String icaoArrivee = route.getArrivalIcao();

					ResponseEntity<?> departResponse = airportsController
							.getAirport(new AirportsRequest(iataDepart, icaoDepart));

					if (departResponse.getStatusCode().equals(HttpStatus.OK)) {
						ResponseEntity<?> arriveeResponse = airportsController
								.getAirport(new AirportsRequest(iataArrivee, icaoArrivee));

						if (arriveeResponse.getStatusCode().equals(HttpStatus.OK)) {
							Airport depart = ((List<Airport>) departResponse.getBody()).get(0);
							Airport arrivee = ((List<Airport>) arriveeResponse.getBody()).get(0);

							Double latA = Double.parseDouble(depart.getLatitudeAirport());
							Double lonA = Double.parseDouble(depart.getLongitudeAirport());
							Double latB = Double.parseDouble(arrivee.getLatitudeAirport());
							Double lonB = Double.parseDouble(arrivee.getLongitudeAirport());

							Double distance = earthUtils.computeDistance(latA, lonA, latB, lonB);
							for (Route r : response) {
								r.setDistance(distance);
							}
						}
					}
				}

				return ResponseEntity.ok(response);
			}

			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500)
					.body("Une erreur est survenue pendant la recherche de routes : " + e.getMessage());
		}

	}
}
