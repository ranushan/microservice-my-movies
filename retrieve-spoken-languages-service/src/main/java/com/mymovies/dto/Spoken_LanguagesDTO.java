package com.mymovies.dto;

public class Spoken_LanguagesDTO {
	
	// Attributs
	
	private String iso_639_1;
	
	private String name;

	// Override toString
	
	@Override
	public String toString() {
		return "Spoken_LanguagesDTO [iso_639_1=" + iso_639_1 + ", name=" + name + "]";
	}

	// Constructor From SuperClass
	
	public Spoken_LanguagesDTO() {
		super();
	}

	// Constructor Using Fields
	
	public Spoken_LanguagesDTO(String iso_639_1, String name) {
		super();
		this.iso_639_1 = iso_639_1;
		this.name = name;
	}

	// Getters and Setters
	
	public String getIso_639_1() {
		return iso_639_1;
	}

	public void setIso_639_1(String iso_639_1) {
		this.iso_639_1 = iso_639_1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}