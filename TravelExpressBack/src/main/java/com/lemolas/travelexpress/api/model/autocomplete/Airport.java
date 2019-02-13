package com.lemolas.travelexpress.api.model.autocomplete;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Airport {

	private String name;

	private String id;

	@JsonCreator
	public Airport(@JsonProperty("nameAirport") String name, @JsonProperty("codeIcaoAirport") String id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public String getId() {
		return this.id;
	}
}
