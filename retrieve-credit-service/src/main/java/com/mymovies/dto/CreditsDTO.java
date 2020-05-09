package com.mymovies.dto;

import java.util.ArrayList;

public class CreditsDTO {

	// Attributs

	private int id;

	private ArrayList<CastDTO> cast;

	private ArrayList<CrewDTO> crew;

	// Override toString

	@Override
	public String toString() {
		return "CreditsDTO [id=" + id + ", cast=" + cast + ", crew=" + crew + "]";
	}

	// Constructor From SuperClass

	public CreditsDTO() {
		super();
	}

	// Constructor Using Fields

	public CreditsDTO(int id, ArrayList<CastDTO> cast, ArrayList<CrewDTO> crew) {
		super();
		this.id = id;
		this.cast = cast;
		this.crew = crew;
	}

	// Getters and Setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<CastDTO> getCast() {
		return cast;
	}

	public void setCast(ArrayList<CastDTO> cast) {
		this.cast = cast;
	}

	public ArrayList<CrewDTO> getCrew() {
		return crew;
	}

	public void setCrew(ArrayList<CrewDTO> crew) {
		this.crew = crew;
	}

}