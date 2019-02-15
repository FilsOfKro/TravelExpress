package com.lemolas.travelexpress.api.model.airports;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Airport implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -224073681877116829L;
	private String airportId;
	private String nameAirport;
	private String codeIataAirport;
	private String codeIcaoAirport;
	private String latitudeAirport;
	private String longitudeAirport;
	private String geonameId;
	private String gmt;
	private String nameCountry;
	private String codeIso2Country;
	private String codeIataCity;

	@JsonCreator
	public Airport(@JsonProperty("airportId") String airportId, @JsonProperty("nameAirport") String nameAirport,
			@JsonProperty("codeIataAirport") String codeIataAirport,
			@JsonProperty("codeIcaoAirport") String codeIcaoAirport,
			@JsonProperty("latitudeAirport") String latitudeAirport,
			@JsonProperty("longitudeAirport") String longitudeAirport, @JsonProperty("geonameId") String geonameId,
			@JsonProperty("GMT") String gmt, @JsonProperty("airlineIata") String airlineIata,
			@JsonProperty("codeIso2Country") String codeIso2Country,
			@JsonProperty("codeIataCity") String codeIataCity) {
		this.airportId = airportId;
		this.nameAirport = nameAirport;
		this.codeIataAirport = codeIataAirport;
		this.codeIcaoAirport = codeIcaoAirport;
		this.latitudeAirport = latitudeAirport;
		this.longitudeAirport = longitudeAirport;
		this.geonameId = geonameId;
		this.gmt = gmt;
		this.nameCountry = airlineIata;
		this.codeIso2Country = codeIso2Country;
		this.codeIataCity = codeIataCity;
	}

	public String getAirportId() {
		return airportId;
	}

	public String getNameAirport() {
		return nameAirport;
	}

	public String getCodeIataAirport() {
		return codeIataAirport;
	}

	public String getCodeIcaoAirport() {
		return codeIcaoAirport;
	}

	public String getLatitudeAirport() {
		return latitudeAirport;
	}

	public String getLongitudeAirport() {
		return longitudeAirport;
	}

	public String getGeonameId() {
		return geonameId;
	}

	public String getGmt() {
		return gmt;
	}

	public String getNameCountry() {
		return nameCountry;
	}

	public String getCodeIso2Country() {
		return codeIso2Country;
	}

	public String getCodeIataCity() {
		return codeIataCity;
	}
}
