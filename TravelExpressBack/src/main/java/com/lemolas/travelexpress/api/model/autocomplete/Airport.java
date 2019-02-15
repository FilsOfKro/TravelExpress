package com.lemolas.travelexpress.api.model.autocomplete;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Airport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1594381393658740293L;

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
