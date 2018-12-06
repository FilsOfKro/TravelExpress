package com.lemolas.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lemolas.bean.Voyage;

public interface VoyageRepository extends MongoRepository<Voyage, String> {

	public Voyage findByVilleDepart(String villeDepart);
}
