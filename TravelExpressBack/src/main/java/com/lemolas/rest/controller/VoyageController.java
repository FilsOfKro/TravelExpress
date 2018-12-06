package com.lemolas.rest.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lemolas.bean.Voyage;
import com.lemolas.repositories.VoyageRepository;

@Component
@RestController
@RequestMapping("/voyage")
public class VoyageController {

	private static final Logger log = LoggerFactory.getLogger(VoyageController.class);

	private VoyageRepository repository;

	@Autowired
	public VoyageController(VoyageRepository repository) {
		this.repository = repository;
	}

	@PutMapping
	public HttpStatus createSampleVoyage() {
		log.info("createSampleVoyage");
		Voyage voyage = new Voyage(String.valueOf(new Date().getTime()), String.valueOf(new Date().getTime()), "Brest",
				"Paris", 549.42, "avion");
		return createVoyage(voyage);
	}

	@GetMapping
	// @Cacheable
	public List<Voyage> getAllVoyage() {
		log.info("getAllVoyage");
		return repository.findAll();
	}

	@PostMapping
	public HttpStatus createVoyage(@RequestParam Voyage voyage) {
		log.info("createVoyage");
		repository.save(voyage);
		return HttpStatus.OK;
	}
}
