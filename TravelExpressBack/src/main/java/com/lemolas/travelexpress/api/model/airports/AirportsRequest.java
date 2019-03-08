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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeIataAirport == null) ? 0 : codeIataAirport.hashCode());
		result = prime * result + ((codeIcaoAirport == null) ? 0 : codeIcaoAirport.hashCode());
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
		if (!(obj instanceof AirportsRequest)) {
			return false;
		}
		AirportsRequest other = (AirportsRequest) obj;
		if (codeIataAirport == null) {
			if (other.codeIataAirport != null) {
				return false;
			}
		} else if (!codeIataAirport.equals(other.codeIataAirport)) {
			return false;
		}
		if (codeIcaoAirport == null) {
			if (other.codeIcaoAirport != null) {
				return false;
			}
		} else if (!codeIcaoAirport.equals(other.codeIcaoAirport)) {
			return false;
		}
		return true;
	}

}
