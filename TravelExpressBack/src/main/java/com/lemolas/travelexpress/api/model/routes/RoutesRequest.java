package com.lemolas.travelexpress.api.model.routes;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RoutesRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1643852702094319761L;
	private String departureAirportId;
	private String arrivalAirportId;

	@JsonCreator
	public RoutesRequest(@JsonProperty String departureAirportId, @JsonProperty String arrivalAirportId) {
		this.departureAirportId = departureAirportId;
		this.arrivalAirportId = arrivalAirportId;
	}

	public String getDepartureAirportId() {
		return departureAirportId;
	}

	public String getArrivalAirportId() {
		return arrivalAirportId;
	}
}
