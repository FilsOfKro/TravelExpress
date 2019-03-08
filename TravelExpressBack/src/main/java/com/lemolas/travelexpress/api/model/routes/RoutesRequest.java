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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalAirportId == null) ? 0 : arrivalAirportId.hashCode());
		result = prime * result + ((departureAirportId == null) ? 0 : departureAirportId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof RoutesRequest)) {
			return false;
		}
		RoutesRequest other = (RoutesRequest) obj;
		if (arrivalAirportId == null) {
			if (other.arrivalAirportId != null) {
				return false;
			}
		} else if (!arrivalAirportId.equals(other.arrivalAirportId)) {
			return false;
		}
		if (departureAirportId == null) {
			if (other.departureAirportId != null) {
				return false;
			}
		} else if (!departureAirportId.equals(other.departureAirportId)) {
			return false;
		}
		return true;
	}

}
