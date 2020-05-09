package com.mymovies.dto;

import java.util.ArrayList;

public class CreditDTO {

	// Attributs

	private int id;
	
	private ArrayList<CrewDTO> crew;
	
	
	// Override toString
	
	@Override
	public String toString() {
		return "CreditDTO [id=" + id + ", crew=" + crew + "]";
	}
	
	// Constructor From SuperClass
	
	public CreditDTO() {
		super();
	}

	// Constructor Using Fields
	
	public CreditDTO(int id, ArrayList<CrewDTO> crew) {
		super();
		this.id = id;
		this.crew = crew;
	}
	
	// Getters and Setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<CrewDTO> getCrew() {
		return crew;
	}

	public void setCrew(ArrayList<CrewDTO> crew) {
		this.crew = crew;
	}
	
}