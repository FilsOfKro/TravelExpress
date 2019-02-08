package com.lemolas.travelexpress.api.model.autocomplete;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Airport {

	private String name;

	private String icao;

	@JsonCreator
	public Airport(@JsonProperty("nameAirport") String name, @JsonProperty("codeIcaoAirport") String icao) {
		this.name = name;
		this.icao = icao;
	}

	public String getName() {
		return this.name;
	}

	public String getIcao() {
		return this.icao;
	}
}
