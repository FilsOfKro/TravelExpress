package com.lemolas.travelexpress.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lemolas.travelexpress.api.model.autocomplete.AutocompleteRequest;
import com.lemolas.travelexpress.api.model.autocomplete.AutocompleteResponse;

@RestController
@RequestMapping("/autocomplete")
@Component
public class AutocompleteController {

	private Logger log = LoggerFactory.getLogger(AutocompleteController.class);

	private static final String apiPath = "autocomplete";

	private RestTemplate restTemplate;

	private String apiUrl;

	private String apiKey;

	@Autowired
	public AutocompleteController(RestTemplate restTemplate, @Value("${travelexpress.flight.api.url}") String apiUrl,
			@Value("${travelexpress.flight.api.key}") String apiKey) {
		this.restTemplate = restTemplate;
		this.apiUrl = apiUrl;
		this.apiKey = apiKey;
	}

	@GetMapping
	public ResponseEntity<?> getAutocompleteInfo(@RequestParam("input") AutocompleteRequest request) {
		String finalUrl = apiUrl + apiPath + "?key={key}&city={city}";

		log.info("About to call {} with apiKey {} and input {}", finalUrl, apiKey, request.getInput());

		AutocompleteResponse response = restTemplate.getForObject(finalUrl, AutocompleteResponse.class, apiKey,
				request.getInput());

		if (response == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(response);
	}
}
