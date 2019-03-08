package com.lemolas.travelexpress.api.model.airline;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AirlineResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2162724624303680301L;

	private String nameAirline;

	private String codeIso2Country;

	private String sizeAirline;

	@JsonCreator
	public AirlineResponse(@JsonProperty("nameAirline") String nameAirline,
			@JsonProperty("codeIso2Country") String codeIso2Country, @JsonProperty("sizeAirline") String sizeAirline) {
		this.nameAirline = nameAirline;
		this.codeIso2Country = codeIso2Country;
		this.sizeAirline = sizeAirline;
	}

	public String getNameAirline() {
		return nameAirline;
	}

	public String getCodeIso2Country() {
		return codeIso2Country;
	}

	public String getSizeAirline() {
		return sizeAirline;
	}

}
