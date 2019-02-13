package com.lemolas.travelexpress.api.model.routes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RoutesResponse {
	private List<Route> routes;

	@JsonCreator
	public RoutesResponse(@JsonProperty List<Route> routes) {
		this.routes = routes;
	}

	public List<Route> getRoutes() {
		return this.routes;
	}
}
