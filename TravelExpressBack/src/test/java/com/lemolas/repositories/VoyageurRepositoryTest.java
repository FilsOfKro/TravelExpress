package com.lemolas.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lemolas.bean.Voyageur;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VoyageurRepositoryTest {

	@Autowired
	private VoyageurRepository voyageurRepository;

	@Before
	public void setUp() throws Exception {
		Voyageur v1 = new Voyageur("Alice", "oui", new Date(0), "42");
		Voyageur v2 = new Voyageur("Bob", "Le bricoleur", new Date(0), "9");
		// save user, verify has ID value after save
		assertNull(v1.getId());
		assertNull(v2.getId());// null before save
		this.voyageurRepository.save(v1);
		this.voyageurRepository.save(v2);
		assertNotNull(v1.getId());
		assertNotNull(v2.getId());
	}

	@Test
	public void testFetchData() {
		/* Test data retrieval */
		List<Voyageur> v1 = voyageurRepository.findVoyageurByName("Bob");
		assertNotNull(v1);
		assertEquals("9", v1.get(0).getPassportNumber());
		/* Get all products, list should only have two */
		Iterable<Voyageur> voyageurs = voyageurRepository.findAll();
		for (Voyageur v : voyageurs) {
			System.out.println(v);
		}
	}
}
