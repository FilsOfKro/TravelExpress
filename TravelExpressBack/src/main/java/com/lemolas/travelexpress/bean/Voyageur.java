package com.lemolas.travelexpress.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voyageur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -236620864197817171L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	private String surname;

	private Date birthdate;

	private String passportNumber;

	/**
	 * Default constructor for JPA
	 */
	public Voyageur() {
	}

	public Voyageur(String name, String surname, Date birthdate, String passportNumber) {
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.passportNumber = passportNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[name=" + name + ", surname=" + surname + ", birthdate="
				+ birthdate.toString() + ", passportNumber=" + passportNumber + "]";
	}
}
