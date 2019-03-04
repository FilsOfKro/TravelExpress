package com.lemolas.travelexpress.api.model.autocomplete;

import java.io.Serializable;

public class AutocompleteRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3724253165567809844L;
	private String input;

	public AutocompleteRequest(String input) {
		this.input = input;
	}

	public String getInput() {
		return input;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((input == null) ? 0 : input.hashCode());
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
		if (!(obj instanceof AutocompleteRequest)) {
			return false;
		}
		AutocompleteRequest other = (AutocompleteRequest) obj;
		if (input == null) {
			if (other.input != null) {
				return false;
			}
		} else if (!input.equals(other.input)) {
			return false;
		}
		return true;
	}

}
