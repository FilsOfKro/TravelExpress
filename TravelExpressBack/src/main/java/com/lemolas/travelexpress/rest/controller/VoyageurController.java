package com.lemolas.travelexpress.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lemolas.travelexpress.bean.Voyageur;
import com.lemolas.travelexpress.repositories.VoyageurRepository;

@Component
@RestController
@RequestMapping("/voyageur")
public class VoyageurController {

	private static final Logger log = LoggerFactory.getLogger(VoyageurController.class);

	private VoyageurRepository repository;

	@Autowired
	public VoyageurController(VoyageurRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Voyageur> getAllVoyageurs() {
		repository.findVoyageurByName("Baron").forEach(v -> System.out.println(v));
		Iterable<Voyageur> voyageurs = repository.findAll();

		List<Voyageur> list = new ArrayList<>();
		voyageurs.forEach(v -> list.add(v));

		return list;
	}

}
