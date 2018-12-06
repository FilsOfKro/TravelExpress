package com.lemolas.bean;

public class Voyage {

	private String dateDepart;

	private String dateArrivee;

	private String villeDepart;

	private String villeArrivee;

	private Double price;

	private String moyenLocomotion;

	public Voyage(String dateDepart, String dateArrivee, String villeDepart, String villeArrivee, Double price,
			String moyenLocomotion) {
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.price = price;
		this.moyenLocomotion = moyenLocomotion;
	}

	public String getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	public String getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(String dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getMoyenLocomotion() {
		return moyenLocomotion;
	}

	public void setMoyenLocomotion(String moyenLocomotion) {
		this.moyenLocomotion = moyenLocomotion;
	}

}
