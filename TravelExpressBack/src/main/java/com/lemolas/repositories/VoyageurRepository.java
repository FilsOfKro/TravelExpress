package com.lemolas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lemolas.bean.Voyageur;

@Repository
public interface VoyageurRepository extends CrudRepository<Voyageur, Integer> {

	public Voyageur findVoyageurByName(String name);
}
