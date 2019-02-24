package com.lemolas.travelexpress.rest.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lemolas.travelexpress.api.model.airports.Airport;
import com.lemolas.travelexpress.api.model.airports.AirportsRequest;
import com.lemolas.travelexpress.api.service.airports.AirportService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("airports")
@Component
public class AirportsController {

	private Logger log = LoggerFactory.getLogger(AirportsController.class);

	private AirportService service;

	@Autowired
	public AirportsController(AirportService service) {
		this.service = service;
	}

	@GetMapping
	@ApiOperation("Retourne les informations de l'aéroport demandé")
	public ResponseEntity<?> getAirport(AirportsRequest request) {

		try {
			Optional<Airport> response = service.getAirport(request);

			if (!response.isPresent()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("Aéroport non trouvé avec les paramètres renseignés.");
			}

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			log.warn("", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Une erreur est survenue pendant la recherche d'aéroport : " + e.getMessage());
		}

	}
}
