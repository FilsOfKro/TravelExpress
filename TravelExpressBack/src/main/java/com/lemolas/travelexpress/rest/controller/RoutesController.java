package com.lemolas.travelexpress.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lemolas.travelexpress.api.model.routes.RoutesRequest;
import com.lemolas.travelexpress.api.model.routes.RoutesResponse;

@RestController
@RequestMapping(RoutesController.apiPath)
@Component
public class RoutesController {

	private Logger log = LoggerFactory.getLogger(RoutesController.class);

	protected static final String apiPath = "routes";

	private RestTemplate restTemplate;

	private String apiUrl;

	private String apiKey;

	@Autowired
	public RoutesController(RestTemplate restTemplate, @Value("${travelexpress.flight.api.url}") String apiUrl,
			@Value("${travelexpress.flight.api.key}") String apiKey) {
		this.restTemplate = restTemplate;
		this.apiUrl = apiUrl;
		this.apiKey = apiKey;
	}

	@GetMapping
	public ResponseEntity<?> getRoutesByAirports(RoutesRequest request) {
		String finalUrl = apiUrl + apiPath
				+ "?key={key}&departureIcao={departureAirportId}&arrivalIcao={departureAirportId}";

		log.info("About to call {} with apiKey {} and departure {} and arrival {}", finalUrl, apiKey,
				request.getDepartureAirportId(), request.getArrivalAirportId());

		@SuppressWarnings("unchecked")
		RoutesResponse response = new RoutesResponse(restTemplate.getForObject(finalUrl, List.class, apiKey,
				request.getDepartureAirportId(), request.getArrivalAirportId()));

		if (response.getRoutes() == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(response);
	}
}
