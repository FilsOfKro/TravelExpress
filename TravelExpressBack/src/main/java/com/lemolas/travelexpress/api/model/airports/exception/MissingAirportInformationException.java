package com.lemolas.travelexpress.api.model.airports.exception;

public class MissingAirportInformationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3506941638120133131L;

	public MissingAirportInformationException() {
		super("Missing airport information.");
	}

	public MissingAirportInformationException(String icao) {
		super("Missing airport information for iaco code " + icao);
	}
}
