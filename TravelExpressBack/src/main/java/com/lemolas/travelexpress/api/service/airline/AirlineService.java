package com.lemolas.travelexpress.api.service.airline;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lemolas.travelexpress.api.model.airline.AirlineResponse;

@Service
public class AirlineService {

	private Logger log = LoggerFactory.getLogger(AirlineService.class);

	protected static final String apiPath = "airlineDatabase";

	private RestTemplate restTemplate;

	private String apiUrl;

	private String apiKey;

	@Autowired
	public AirlineService(RestTemplate restTemplate, @Value("${travelexpress.flight.api.url}") String apiUrl,
			@Value("${travelexpress.flight.api.key}") String apiKey) {
		this.restTemplate = restTemplate;
		this.apiUrl = apiUrl;
		this.apiKey = apiKey;
	}

	@Cacheable(value = "defaultCache")
	public List<AirlineResponse> getAirlineInfo(String iata) {
		String finalUrl = apiUrl + apiPath + "?key={key}&codeIataAirline={codeIataAirline}";

		log.info("About to call {} with apiKey {} and iata {}", finalUrl, apiKey, iata);
		ParameterizedTypeReference<List<AirlineResponse>> listAirlineType = new ParameterizedTypeReference<List<AirlineResponse>>() {
		};

		List<AirlineResponse> response = restTemplate
				.exchange(finalUrl, HttpMethod.GET, null, listAirlineType, apiKey, iata).getBody();

		return response;
	}
}
