package com.lemolas.travelexpress.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Voyageur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -236620864197817171L;

	@Min(0)
	@Max(999)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	private String name;

	@NotNull
	private String surname;

	@NotNull
	private Date birthdate;

	@NotNull
	@Size(min = 9, max = 9)
	@Pattern(regexp = "^[0-9]{2}[A-Z]{2}[0-9]{5}$")
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
