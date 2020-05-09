package com.mymovies.dto;


public class Production_CountriesDTO {

	// Attributs

	private String iso_3166_1;

	private String name;

	// Override to String

	@Override
	public String toString() {
		return "Production_CountriesDTO [iso_3166_1=" + iso_3166_1 + ", name=" + name + "]";
	}

	// Constructor From SuperClass

	public Production_CountriesDTO() {
		super();
	}

	// Constructor Using Fields

	public Production_CountriesDTO(String iso_3166_1, String name) {
		super();
		this.iso_3166_1 = iso_3166_1;
		this.name = name;
	}

	// Getters and Setters

	public String getIso_3166_1() {
		return iso_3166_1;
	}

	public void setIso_3166_1(String iso_3166_1) {
		this.iso_3166_1 = iso_3166_1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}