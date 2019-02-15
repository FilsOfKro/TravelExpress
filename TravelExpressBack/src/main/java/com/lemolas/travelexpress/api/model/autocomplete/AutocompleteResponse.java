package com.lemolas.travelexpress.api.model.autocomplete;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AutocompleteResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2029025192995059416L;
	private List<Airport> airports;

	@JsonCreator
	public AutocompleteResponse(@JsonProperty("airportsByCities") List<Airport> airports) {
		this.airports = airports.stream().filter(a -> !StringUtils.isEmpty(a.getId())).collect(Collectors.toList());
	}

	public List<Airport> getAirports() {
		return this.airports;
	}
}
