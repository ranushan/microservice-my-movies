package com.mymovies.dto;

import java.util.ArrayList;

public class MovieDTO {

	private int id;
	private ArrayList<Production_CompaniesDTO> production_companies;

	// Override toString

	@Override
	public String toString() {
		return "MovieDTO [id=" + id + ", production_companies=" + production_companies + "]";
	}

	// Constructor from SuperClass

	public MovieDTO() {
		super();
	}

	// Constructor Using Fields

	public MovieDTO(int id, ArrayList<Production_CompaniesDTO> production_companies) {
		super();
		this.id = id;
		this.production_companies = production_companies;
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Production_CompaniesDTO> getProduction_companies() {
		return production_companies;
	}

	public void setProduction_companies(ArrayList<Production_CompaniesDTO> production_companies) {
		this.production_companies = production_companies;
	}
}
