package com.lemolas.travelexpress.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lemolas.travelexpress.bean.Utilisateur;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {

	public List<Utilisateur> findByUsernameAndPassword(String username, String password);
}
