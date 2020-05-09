package com.mymovies.dto;

import java.util.ArrayList;

public class MovieDTO {

	// Attributs
	
	private int id;
	
	private ArrayList<Spoken_LanguagesDTO> spoken_languages;

	// Override toString
	
	@Override
	public String toString() {
		return "MovieDTO [id=" + id + ", spoken_languages=" + spoken_languages + "]";
	}

	// Constructor from SuperClass
	
	public MovieDTO() {
		super();
	}
	
	// Constructor Using Fields

	public MovieDTO(int id, ArrayList<Spoken_LanguagesDTO> spoken_languages) {
		super();
		this.id = id;
		this.spoken_languages = spoken_languages;
	}

	// Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Spoken_LanguagesDTO> getSpoken_languages() {
		return spoken_languages;
	}

	public void setSpoken_languages(ArrayList<Spoken_LanguagesDTO> spoken_languages) {
		this.spoken_languages = spoken_languages;
	}
	
}
