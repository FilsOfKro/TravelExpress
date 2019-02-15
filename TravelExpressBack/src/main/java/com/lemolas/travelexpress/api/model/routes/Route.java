package com.lemolas.travelexpress.api.model.routes;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Route implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3972296754209723063L;
	private String departureIata;
	private String departureIcao;
	private String departureTerminal;
	private String departureTime;
	private String arrivalIata;
	private String arrivalIcao;
	private String arrivalTerminal;
	private String arrivalTime;
	private String airlineIata;
	private String airlineIcao;
	private String flightNumber;
	private String regNumber;
	private Double distance;

	@JsonCreator
	public Route(@JsonProperty("departureIata") String departureIata,
			@JsonProperty("departureIcao") String departureIcao,
			@JsonProperty("departureTerminal") String departureTerminal,
			@JsonProperty("departureTime") String departureTime, @JsonProperty("arrivalIata") String arrivalIata,
			@JsonProperty("arrivalIcao") String arrivalIcao, @JsonProperty("arrivalTerminal") String arrivalTerminal,
			@JsonProperty("arrivalTime") String arrivalTime, @JsonProperty("airlineIata") String airlineIata,
			@JsonProperty("airlineIcao") String airlineIcao, @JsonProperty("flightNumber") String flightNumber,
			@JsonProperty("regNumber") String regNumber) {
		this.departureIata = departureIata;
		this.departureIcao = departureIcao;
		this.departureTerminal = departureTerminal;
		this.departureTime = departureTime;
		this.arrivalIata = arrivalIata;
		this.arrivalIcao = arrivalIcao;
		this.arrivalTerminal = arrivalTerminal;
		this.arrivalTime = arrivalTime;
		this.airlineIata = airlineIata;
		this.airlineIcao = airlineIcao;
		this.flightNumber = flightNumber;
		this.regNumber = regNumber;
	}

	public String getDepartureIata() {
		return departureIata;
	}

	public String getDepartureIcao() {
		return departureIcao;
	}

	public String getDepartureTerminal() {
		return departureTerminal;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalIata() {
		return arrivalIata;
	}

	public String getArrivalIcao() {
		return arrivalIcao;
	}

	public String getArrivalTerminal() {
		return arrivalTerminal;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public String getAirlineIata() {
		return airlineIata;
	}

	public String getAirlineIcao() {
		return airlineIcao;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}
}
