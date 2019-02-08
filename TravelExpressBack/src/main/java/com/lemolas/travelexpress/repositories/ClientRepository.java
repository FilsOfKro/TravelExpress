package com.lemolas.travelexpress.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lemolas.travelexpress.bean.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

	public List<Client> findClientByName(String name);
}
