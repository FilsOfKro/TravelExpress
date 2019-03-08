package com.lemolas.travelexpress.rest.controller;

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

import com.lemolas.travelexpress.api.model.autocomplete.AutocompleteRequest;
import com.lemolas.travelexpress.api.model.autocomplete.AutocompleteResponse;
import com.lemolas.travelexpress.api.service.autocomplete.AutocompleteService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("autocomplete")
@Component
public class AutocompleteController {

	private Logger log = LoggerFactory.getLogger(AutocompleteController.class);

	private AutocompleteService service;

	@Autowired
	public AutocompleteController(AutocompleteService service) {
		this.service = service;
	}

	@GetMapping
	@ApiOperation("Retourne des informations d'autocomplétion lors de la recherche d'aéroport")
	public ResponseEntity<?> getAutocompleteInfo(@RequestParam("input") AutocompleteRequest request) {
		AutocompleteResponse response = service.getAutocompleteInfo(request);

		if (response == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Impossible d'obtenir les données d'autocomplétion pour les paramètres renseignés.");
		}

		return ResponseEntity.ok(response.getAirports());
	}
}
