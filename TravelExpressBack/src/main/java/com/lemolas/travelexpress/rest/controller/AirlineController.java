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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lemolas.travelexpress.api.model.airline.AirlineResponse;
import com.lemolas.travelexpress.api.service.airline.AirlineService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("airline")
@Component
public class AirlineController {

	private Logger log = LoggerFactory.getLogger(AirlineController.class);

	private AirlineService service;

	@Autowired
	public AirlineController(AirlineService service) {
		this.service = service;
	}

	@GetMapping
	@ApiOperation("Retourne des informations d'autocomplétion lors de la recherche d'aéroport")
	public ResponseEntity<?> getAirlineInfo(@RequestParam("codeIataAirline") String iata) {
		List<AirlineResponse> response = service.getAirlineInfo(iata);

		if (response.size() == 0) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Impossible d'obtenir les données sur la compagnie aérienne pour les paramètres renseignés.");
		}

		return ResponseEntity.ok(response.get(0));
	}
}
