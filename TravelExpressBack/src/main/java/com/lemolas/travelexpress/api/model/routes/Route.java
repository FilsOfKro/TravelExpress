package com.lemolas.travelexpress.api.model.routes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Route {
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

	@JsonCreator
	public Route(@JsonProperty String departureIata, @JsonProperty String departureIcao,
			@JsonProperty String departureTerminal, @JsonProperty String departureTime,
			@JsonProperty String arrivalIata, @JsonProperty String arrivalIcao, @JsonProperty String arrivalTerminal,
			@JsonProperty String arrivalTime, @JsonProperty String airlineIata, @JsonProperty String airlineIcao,
			@JsonProperty String flightNumber, @JsonProperty String regNumber) {
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
}
