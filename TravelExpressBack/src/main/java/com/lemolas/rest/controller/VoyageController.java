package com.lemolas.rest.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lemolas.bean.Voyage;
import com.lemolas.repositories.VoyageRepository;

@Component
@RestController("/voyage")
public class VoyageController {

	VoyageRepository repository;

	@Autowired
	public VoyageController(VoyageRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	@Cacheable
	public List<Voyage> getAllVoyage() {
		return repository.findAll();
	}

	@PostMapping("sample")
	public HttpStatus createSampleVoyage() {
		Voyage voyage = new Voyage(String.valueOf(new Date().getTime()), String.valueOf(new Date().getTime()), "Brest",
				"Paris", 549.42, "avion");
		return createVoyage(voyage);
	}

	@PostMapping
	public HttpStatus createVoyage(Voyage voyage) {
		repository.save(voyage);
		return HttpStatus.OK;
	}
}
