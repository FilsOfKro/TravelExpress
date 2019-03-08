package com.lemolas.travelexpress.api.model.airports;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Airport implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -224073681877116829L;
	private String airportId;
	private String nameAirport;
	private String codeIataAirport;
	private String codeIcaoAirport;
	private String latitudeAirport;
	private String longitudeAirport;
	private String geonameId;
	private String gmt;
	private String nameCountry;
	private String codeIso2Country;
	private String codeIataCity;

	@JsonCreator
	public Airport(@JsonProperty("airportId") String airportId, @JsonProperty("nameAirport") String nameAirport,
			@JsonProperty("codeIataAirport") String codeIataAirport,
			@JsonProperty("codeIcaoAirport") String codeIcaoAirport,
			@JsonProperty("latitudeAirport") String latitudeAirport,
			@JsonProperty("longitudeAirport") String longitudeAirport, @JsonProperty("geonameId") String geonameId,
			@JsonProperty("GMT") String gmt, @JsonProperty("airlineIata") String airlineIata,
			@JsonProperty("codeIso2Country") String codeIso2Country,
			@JsonProperty("codeIataCity") String codeIataCity) {
		this.airportId = airportId;
		this.nameAirport = nameAirport;
		this.codeIataAirport = codeIataAirport;
		this.codeIcaoAirport = codeIcaoAirport;
		this.latitudeAirport = latitudeAirport;
		this.longitudeAirport = longitudeAirport;
		this.geonameId = geonameId;
		this.gmt = gmt;
		this.nameCountry = airlineIata;
		this.codeIso2Country = codeIso2Country;
		this.codeIataCity = codeIataCity;
	}

	public String getAirportId() {
		return airportId;
	}

	public String getNameAirport() {
		return nameAirport;
	}

	public String getCodeIataAirport() {
		return codeIataAirport;
	}

	public String getCodeIcaoAirport() {
		return codeIcaoAirport;
	}

	public String getLatitudeAirport() {
		return latitudeAirport;
	}

	public String getLongitudeAirport() {
		return longitudeAirport;
	}

	public String getGeonameId() {
		return geonameId;
	}

	public String getGmt() {
		return gmt;
	}

	public String getNameCountry() {
		return nameCountry;
	}

	public String getCodeIso2Country() {
		return codeIso2Country;
	}

	public String getCodeIataCity() {
		return codeIataCity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airportId == null) ? 0 : airportId.hashCode());
		result = prime * result + ((codeIataAirport == null) ? 0 : codeIataAirport.hashCode());
		result = prime * result + ((codeIataCity == null) ? 0 : codeIataCity.hashCode());
		result = prime * result + ((codeIcaoAirport == null) ? 0 : codeIcaoAirport.hashCode());
		result = prime * result + ((codeIso2Country == null) ? 0 : codeIso2Country.hashCode());
		result = prime * result + ((geonameId == null) ? 0 : geonameId.hashCode());
		result = prime * result + ((gmt == null) ? 0 : gmt.hashCode());
		result = prime * result + ((latitudeAirport == null) ? 0 : latitudeAirport.hashCode());
		result = prime * result + ((longitudeAirport == null) ? 0 : longitudeAirport.hashCode());
		result = prime * result + ((nameAirport == null) ? 0 : nameAirport.hashCode());
		result = prime * result + ((nameCountry == null) ? 0 : nameCountry.hashCode());
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
		if (airportId == null) {
			if (other.airportId != null) {
				return false;
			}
		} else if (!airportId.equals(other.airportId)) {
			return false;
		}
		if (codeIataAirport == null) {
			if (other.codeIataAirport != null) {
				return false;
			}
		} else if (!codeIataAirport.equals(other.codeIataAirport)) {
			return false;
		}
		if (codeIataCity == null) {
			if (other.codeIataCity != null) {
				return false;
			}
		} else if (!codeIataCity.equals(other.codeIataCity)) {
			return false;
		}
		if (codeIcaoAirport == null) {
			if (other.codeIcaoAirport != null) {
				return false;
			}
		} else if (!codeIcaoAirport.equals(other.codeIcaoAirport)) {
			return false;
		}
		if (codeIso2Country == null) {
			if (other.codeIso2Country != null) {
				return false;
			}
		} else if (!codeIso2Country.equals(other.codeIso2Country)) {
			return false;
		}
		if (geonameId == null) {
			if (other.geonameId != null) {
				return false;
			}
		} else if (!geonameId.equals(other.geonameId)) {
			return false;
		}
		if (gmt == null) {
			if (other.gmt != null) {
				return false;
			}
		} else if (!gmt.equals(other.gmt)) {
			return false;
		}
		if (latitudeAirport == null) {
			if (other.latitudeAirport != null) {
				return false;
			}
		} else if (!latitudeAirport.equals(other.latitudeAirport)) {
			return false;
		}
		if (longitudeAirport == null) {
			if (other.longitudeAirport != null) {
				return false;
			}
		} else if (!longitudeAirport.equals(other.longitudeAirport)) {
			return false;
		}
		if (nameAirport == null) {
			if (other.nameAirport != null) {
				return false;
			}
		} else if (!nameAirport.equals(other.nameAirport)) {
			return false;
		}
		if (nameCountry == null) {
			if (other.nameCountry != null) {
				return false;
			}
		} else if (!nameCountry.equals(other.nameCountry)) {
			return false;
		}
		return true;
	}

}
