package com.mymovies.dto;

import java.util.ArrayList;

public class CreditDTO {

	// Attributs

	private int id;
	
	private ArrayList<CastDTO> cast;
	
	
	// Override toString
	
	@Override
	public String toString() {
		return "CreditDTO [id=" + id + ", cast=" + cast + "]";
	}
	
	// Constructor From SuperClass
	
	public CreditDTO() {
		super();
	}

	// Constructor Using Fields
	
	public CreditDTO(int id, ArrayList<CastDTO> cast) {
		super();
		this.id = id;
		this.cast = cast;
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
	
}