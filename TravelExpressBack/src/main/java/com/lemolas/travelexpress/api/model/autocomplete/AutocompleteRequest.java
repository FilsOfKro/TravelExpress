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
}
