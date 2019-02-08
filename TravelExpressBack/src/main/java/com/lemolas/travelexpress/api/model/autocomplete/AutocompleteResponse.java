package com.lemolas.travelexpress.api.model.autocomplete;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AutocompleteResponse {

	private List<Airport> airports;

	@JsonCreator
	public AutocompleteResponse(@JsonProperty("airportsByCities") List<Airport> airports) {
		this.airports = airports.stream().filter(a -> !StringUtils.isEmpty(a.getIcao())).collect(Collectors.toList());
	}

	public List<Airport> getAirports() {
		return this.airports;
	}
}
