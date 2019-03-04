package com.lemolas.travelexpress.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lemolas.travelexpress.bean.Voyageur;
import com.lemolas.travelexpress.repositories.VoyageurRepository;

@Component
@RestController
@RequestMapping("/voyageur")
@Validated
public class VoyageurController {

	private static final Logger log = LoggerFactory.getLogger(VoyageurController.class);

	private VoyageurRepository repository;

	@Autowired
	public VoyageurController(VoyageurRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	@Cacheable(value = "defaultCache")
	public List<@Valid Voyageur> getAllVoyageurs() {
		long start = System.currentTimeMillis();
		Iterable<Voyageur> voyageurs = repository.findAll();

		List<Voyageur> list = new ArrayList<>();
		voyageurs.forEach(v -> list.add(v));

		log.warn("Ended in : " + (System.currentTimeMillis() - start) + "ms");

		return list;
	}

	@PostMapping
	public Voyageur createVoyageur(@Valid @RequestBody Voyageur voyageur) {
		return repository.save(voyageur);
	}

	@GetMapping("/{id}")
	@Cacheable(value = "defaultCache")
	public Optional<@Valid Voyageur> getVoyageurById(@PathVariable("id") Integer id) {
		Optional<Voyageur> voyageur = repository.findById(id);

		return voyageur;
	}

}
