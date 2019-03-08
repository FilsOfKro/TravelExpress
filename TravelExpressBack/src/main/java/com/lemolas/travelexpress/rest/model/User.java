package com.lemolas.travelexpress.rest.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6049981715157681052L;

	@NotNull
	private String username;

	@NotNull
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonCreator
	public User(@JsonProperty("username") @NotNull String username,
			@JsonProperty("password") @NotNull String password) {
		this.username = username;
		this.password = password;
	}
}