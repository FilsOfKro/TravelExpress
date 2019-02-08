package com.lemolas.travelexpress.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lemolas.travelexpress.bean.Voyageur;

@Repository
public interface VoyageurRepository extends CrudRepository<Voyageur, Integer> {

	public List<Voyageur> findVoyageurByName(String name);
}
