package com.lemolas.travelexpress.api.model.routes;

import java.util.List;

public class RoutesResponse {
	private List<Route> routes;

	public RoutesResponse(List<Route> routes) {
		this.routes = routes;
	}

	public List<Route> getRoutes() {
		return this.routes;
	}
}
