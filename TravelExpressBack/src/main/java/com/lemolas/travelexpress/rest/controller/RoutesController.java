package com.lemolas.travelexpress.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lemolas.travelexpress.api.model.routes.Route;
import com.lemolas.travelexpress.api.model.routes.RoutesRequest;
import com.lemolas.travelexpress.api.service.routes.RoutesService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(RoutesController.apiPath)
@Component
public class RoutesController {

	private Logger log = LoggerFactory.getLogger(RoutesController.class);

	protected static final String apiPath = "routes";

	private RoutesService service;

	@Autowired
	public RoutesController(RoutesService service) {
		this.service = service;
	}

	@GetMapping
	@ApiOperation("Retourne un ensemble de routes entre deux aéroports donnés")
	public ResponseEntity<?> getRoutesByAirports(RoutesRequest request) {
		try {
			List<Route> response = service.getRoutes(request);
			if (response != null) {

				if (!response.isEmpty()) {
					Route route = response.get(0);

					Double distance = service.computeDistance(route);
					for (Route r : response) {
						r.setDistance(distance);
					}

					return ResponseEntity.ok(response);
				}
			}

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Route non trouvée pour les paramètres renseignés.");
		} catch (Exception e) {
			log.warn("", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Une erreur est survenue pendant la recherche de routes : " + e.getMessage());
		}

	}
}
