package com.lemolas.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Voyageur")
public class Voyageur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "birthdate")
	private Date birthdate;

	@Column(name = "passportNumber")
	private String passportNumber;

	/**
	 * Default constructor for JPA
	 */
	public Voyageur() {
		System.out.println("???");
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
