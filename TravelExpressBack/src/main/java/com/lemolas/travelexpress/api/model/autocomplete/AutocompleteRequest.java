package com.lemolas.travelexpress.api.model.autocomplete;

public class AutocompleteRequest {

	private String input;

	public AutocompleteRequest(String input) {
		this.input = input;
	}

	public String getInput() {
		return input;
	}
}
