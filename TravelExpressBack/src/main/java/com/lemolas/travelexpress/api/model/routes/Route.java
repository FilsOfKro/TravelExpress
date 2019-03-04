package com.lemolas.travelexpress.api.model.routes;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Route implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3972296754209723063L;
	private String departureIata;
	private String departureIcao;
	private String departureTerminal;
	private String departureTime;
	private String arrivalIata;
	private String arrivalIcao;
	private String arrivalTerminal;
	private String arrivalTime;
	private String airlineIata;
	private String airlineIcao;
	private String flightNumber;
	private String regNumber;
	private Double distance;

	@JsonCreator
	public Route(@JsonProperty("departureIata") String departureIata,
			@JsonProperty("departureIcao") String departureIcao,
			@JsonProperty("departureTerminal") String departureTerminal,
			@JsonProperty("departureTime") String departureTime, @JsonProperty("arrivalIata") String arrivalIata,
			@JsonProperty("arrivalIcao") String arrivalIcao, @JsonProperty("arrivalTerminal") String arrivalTerminal,
			@JsonProperty("arrivalTime") String arrivalTime, @JsonProperty("airlineIata") String airlineIata,
			@JsonProperty("airlineIcao") String airlineIcao, @JsonProperty("flightNumber") String flightNumber,
			@JsonProperty("regNumber") String regNumber) {
		this.departureIata = departureIata;
		this.departureIcao = departureIcao;
		this.departureTerminal = departureTerminal;
		this.departureTime = departureTime;
		this.arrivalIata = arrivalIata;
		this.arrivalIcao = arrivalIcao;
		this.arrivalTerminal = arrivalTerminal;
		this.arrivalTime = arrivalTime;
		this.airlineIata = airlineIata;
		this.airlineIcao = airlineIcao;
		this.flightNumber = flightNumber;
		this.regNumber = regNumber;
	}

	public String getDepartureIata() {
		return departureIata;
	}

	public String getDepartureIcao() {
		return departureIcao;
	}

	public String getDepartureTerminal() {
		return departureTerminal;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalIata() {
		return arrivalIata;
	}

	public String getArrivalIcao() {
		return arrivalIcao;
	}

	public String getArrivalTerminal() {
		return arrivalTerminal;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public String getAirlineIata() {
		return airlineIata;
	}

	public String getAirlineIcao() {
		return airlineIcao;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airlineIata == null) ? 0 : airlineIata.hashCode());
		result = prime * result + ((airlineIcao == null) ? 0 : airlineIcao.hashCode());
		result = prime * result + ((arrivalIata == null) ? 0 : arrivalIata.hashCode());
		result = prime * result + ((arrivalIcao == null) ? 0 : arrivalIcao.hashCode());
		result = prime * result + ((arrivalTerminal == null) ? 0 : arrivalTerminal.hashCode());
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		result = prime * result + ((departureIata == null) ? 0 : departureIata.hashCode());
		result = prime * result + ((departureIcao == null) ? 0 : departureIcao.hashCode());
		result = prime * result + ((departureTerminal == null) ? 0 : departureTerminal.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + ((regNumber == null) ? 0 : regNumber.hashCode());
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
		if (!(obj instanceof Route)) {
			return false;
		}
		Route other = (Route) obj;
		if (airlineIata == null) {
			if (other.airlineIata != null) {
				return false;
			}
		} else if (!airlineIata.equals(other.airlineIata)) {
			return false;
		}
		if (airlineIcao == null) {
			if (other.airlineIcao != null) {
				return false;
			}
		} else if (!airlineIcao.equals(other.airlineIcao)) {
			return false;
		}
		if (arrivalIata == null) {
			if (other.arrivalIata != null) {
				return false;
			}
		} else if (!arrivalIata.equals(other.arrivalIata)) {
			return false;
		}
		if (arrivalIcao == null) {
			if (other.arrivalIcao != null) {
				return false;
			}
		} else if (!arrivalIcao.equals(other.arrivalIcao)) {
			return false;
		}
		if (arrivalTerminal == null) {
			if (other.arrivalTerminal != null) {
				return false;
			}
		} else if (!arrivalTerminal.equals(other.arrivalTerminal)) {
			return false;
		}
		if (arrivalTime == null) {
			if (other.arrivalTime != null) {
				return false;
			}
		} else if (!arrivalTime.equals(other.arrivalTime)) {
			return false;
		}
		if (departureIata == null) {
			if (other.departureIata != null) {
				return false;
			}
		} else if (!departureIata.equals(other.departureIata)) {
			return false;
		}
		if (departureIcao == null) {
			if (other.departureIcao != null) {
				return false;
			}
		} else if (!departureIcao.equals(other.departureIcao)) {
			return false;
		}
		if (departureTerminal == null) {
			if (other.departureTerminal != null) {
				return false;
			}
		} else if (!departureTerminal.equals(other.departureTerminal)) {
			return false;
		}
		if (departureTime == null) {
			if (other.departureTime != null) {
				return false;
			}
		} else if (!departureTime.equals(other.departureTime)) {
			return false;
		}
		if (distance == null) {
			if (other.distance != null) {
				return false;
			}
		} else if (!distance.equals(other.distance)) {
			return false;
		}
		if (flightNumber == null) {
			if (other.flightNumber != null) {
				return false;
			}
		} else if (!flightNumber.equals(other.flightNumber)) {
			return false;
		}
		if (regNumber == null) {
			if (other.regNumber != null) {
				return false;
			}
		} else if (!regNumber.equals(other.regNumber)) {
			return false;
		}
		return true;
	}

}
