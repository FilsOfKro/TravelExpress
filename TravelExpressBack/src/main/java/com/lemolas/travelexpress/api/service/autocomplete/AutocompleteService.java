package com.lemolas.travelexpress.api.service.autocomplete;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lemolas.travelexpress.api.model.autocomplete.AutocompleteRequest;
import com.lemolas.travelexpress.api.model.autocomplete.AutocompleteResponse;

@Service
public class AutocompleteService {

	private Logger log = LoggerFactory.getLogger(AutocompleteService.class);

	protected static final String apiPath = "autocomplete";

	private RestTemplate restTemplate;

	private String apiUrl;

	private String apiKey;

	@Autowired
	public AutocompleteService(RestTemplate restTemplate, @Value("${travelexpress.flight.api.url}") String apiUrl,
			@Value("${travelexpress.flight.api.key}") String apiKey) {
		this.restTemplate = restTemplate;
		this.apiUrl = apiUrl;
		this.apiKey = apiKey;
	}

	@Cacheable(value = "defaultCache")
	public AutocompleteResponse getAutocompleteInfo(AutocompleteRequest request) {
		String finalUrl = apiUrl + apiPath + "?key={key}&city={city}";

		log.info("About to call {} with apiKey {} and input {}", finalUrl, apiKey, request.getInput());

		AutocompleteResponse response = restTemplate.getForObject(finalUrl, AutocompleteResponse.class, apiKey,
				request.getInput());

		return response;
	}
}
