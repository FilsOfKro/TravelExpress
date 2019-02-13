package com.lemolas.travelexpress.api.model.routes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RoutesRequest {

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
