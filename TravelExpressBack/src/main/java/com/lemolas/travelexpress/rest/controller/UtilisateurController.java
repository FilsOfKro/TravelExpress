package com.lemolas.travelexpress.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lemolas.travelexpress.bean.Utilisateur;
import com.lemolas.travelexpress.repositories.UtilisateurRepository;
import com.lemolas.travelexpress.rest.model.User;

@RestController
@RequestMapping("/authentication")
public class UtilisateurController {

	private UtilisateurRepository repository;

	@Autowired
	public UtilisateurController(UtilisateurRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	public ResponseEntity<?> authenticate(@Valid @RequestBody User user) {
		List<Utilisateur> utilisateur = repository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

		if (utilisateur.size() > 0) {
			return ResponseEntity.ok(utilisateur.get(0));
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
}
