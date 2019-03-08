package com.lemolas.travelexpress.api.service.airports;

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

@Service
public class AirportService {

	private Logger log = LoggerFactory.getLogger(AirportService.class);

	protected static final String apiPath = "airportDatabase";

	private RestTemplate restTemplate;

	private String apiUrl;

	private String apiKey;

	@Autowired
	public AirportService(RestTemplate restTemplate, @Value("${travelexpress.flight.api.url}") String apiUrl,
			@Value("${travelexpress.flight.api.key}") String apiKey) {
		this.restTemplate = restTemplate;
		this.apiUrl = apiUrl;
		this.apiKey = apiKey;
	}

	@Cacheable(value = "defaultCache")
	public Optional<Airport> getAirport(AirportsRequest request) {
		String finalUrl = apiUrl + apiPath + "?key={key}&codeIataAirport={codeIataAirport}";

		log.info("About to call {} with apiKey {} and iata {}", finalUrl, apiKey, request.getCodeIataAirport());

		ParameterizedTypeReference<List<Airport>> listAirportType = new ParameterizedTypeReference<List<Airport>>() {
		};

		List<Airport> airports = restTemplate
				.exchange(finalUrl, HttpMethod.GET, null, listAirportType, apiKey, request.getCodeIataAirport())
				.getBody();

		Optional<Airport> response = airports.stream()
				.filter(a -> request.getCodeIcaoAirport().equals(a.getCodeIcaoAirport())).findAny();

		return response;
	}
}
