package com.lemolas.travelexpress.api.model.autocomplete;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AutocompleteResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2029025192995059416L;
	private List<Airport> airports;

	@JsonCreator
	public AutocompleteResponse(@JsonProperty("airportsByCities") List<Airport> airports) {
		this.airports = airports.stream().filter(a -> !StringUtils.isEmpty(a.getId())).collect(Collectors.toList());
	}

	public List<Airport> getAirports() {
		return this.airports;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airports == null) ? 0 : airports.hashCode());
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
		if (!(obj instanceof AutocompleteResponse)) {
			return false;
		}
		AutocompleteResponse other = (AutocompleteResponse) obj;
		if (airports == null) {
			if (other.airports != null) {
				return false;
			}
		} else if (!airports.equals(other.airports)) {
			return false;
		}
		return true;
	}

}
