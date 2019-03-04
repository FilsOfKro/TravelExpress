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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof Airport)) {
			return false;
		}
		Airport other = (Airport) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
