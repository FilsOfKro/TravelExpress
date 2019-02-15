package com.lemolas.travelexpress.api.model.airports;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AirportsRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6844955595756887993L;
	private String codeIataAirport;
	private String codeIcaoAirport;

	@JsonCreator
	public AirportsRequest(@JsonProperty String codeIataAirport, @JsonProperty String codeIcaoAirport) {
		this.codeIataAirport = codeIataAirport;
		this.codeIcaoAirport = codeIcaoAirport;
	}

	public String getCodeIataAirport() {
		return codeIataAirport;
	}

	public String getCodeIcaoAirport() {
		return codeIcaoAirport;
	}
}
