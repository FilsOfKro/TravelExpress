package com.lemolas.travelexpress.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1432888352696821105L;

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
	private String address;

	@Email
	private String email;
}
