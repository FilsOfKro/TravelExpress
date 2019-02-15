package com.lemolas.travelexpress.rest.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lemolas.travelexpress.api.model.airports.Airport;
import com.lemolas.travelexpress.api.model.airports.AirportsRequest;

@RestController
@RequestMapping("airports")
@Component
public class AirportsController {

	private Logger log = LoggerFactory.getLogger(AirportsController.class);

	protected static final String apiPath = "airportDatabase";

	private RestTemplate restTemplate;

	private String apiUrl;

	private String apiKey;

	@Autowired
	public AirportsController(RestTemplate restTemplate, @Value("${travelexpress.flight.api.url}") String apiUrl,
			@Value("${travelexpress.flight.api.key}") String apiKey) {
		this.restTemplate = restTemplate;
		this.apiUrl = apiUrl;
		this.apiKey = apiKey;
	}

	@GetMapping
	// @Cacheable(value = "defaultCache")
	public ResponseEntity<?> getAirport(AirportsRequest request) {
		String finalUrl = apiUrl + apiPath + "?key={key}&codeIataAirport={codeIataAirport}";

		log.info("About to call {} with apiKey {} and iata {}", finalUrl, apiKey, request.getCodeIataAirport());

		try {
			ParameterizedTypeReference<List<Airport>> listAirportType = new ParameterizedTypeReference<List<Airport>>() {
			};

			List<Airport> airports = restTemplate
					.exchange(finalUrl, HttpMethod.GET, null, listAirportType, apiKey, request.getCodeIataAirport())
					.getBody();

			Optional<Airport> response = airports.stream()
					.filter(a -> request.getCodeIcaoAirport().equals(a.getCodeIcaoAirport())).findAny();

			if (!response.isPresent()) {
				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.ok(airports);
		} catch (Exception e) {
			log.error("", e);
			return ResponseEntity.status(500)
					.body("Une erreur est survenue pendant la recherche d'aéroport : " + e.getMessage());
		}

	}
}
