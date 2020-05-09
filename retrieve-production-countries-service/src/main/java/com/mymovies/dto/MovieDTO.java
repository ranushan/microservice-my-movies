package com.mymovies.dto;

import java.util.ArrayList;

public class MovieDTO {

	// Attributs

	private int id;

	private ArrayList<Production_CountriesDTO> production_countries;


	@Override
	public String toString() {
		return "MovieDTO [id=" + id + ", production_countries=" + production_countries + "]";
	}

	// Constructor from SuperClass

	public MovieDTO() {
		super();
	}

	// Constructor Using Fields

	public MovieDTO(int id, ArrayList<Production_CountriesDTO> production_countries) {
		super();
		this.id = id;
		this.production_countries = production_countries;

	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Production_CountriesDTO> getProduction_countries() {
		return production_countries;
	}

	public void setProduction_countries(ArrayList<Production_CountriesDTO> production_countries) {
		this.production_countries = production_countries;
	}

}