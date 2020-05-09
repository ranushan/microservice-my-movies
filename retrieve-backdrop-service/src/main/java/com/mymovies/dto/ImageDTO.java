package com.mymovies.dto;

import java.util.ArrayList;

public class ImageDTO {

	// Attributs
	
	private int id;
	
	private ArrayList<BackDropDTO> backdrops;
	
	// Override toString
	
	@Override
	public String toString() {
		return "ImageDTO [id=" + id + ", backdrops=" + backdrops + "]";
	}

	// Constructor From SuperClass
	
	public ImageDTO() {
		super();
	}

	// Constructor Using Fields

	public ImageDTO(int id, ArrayList<BackDropDTO> backdrops) {
		super();
		this.id = id;
		this.backdrops = backdrops;
	}

	// Getters and Setters

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public ArrayList<BackDropDTO> getBackdrops() {
		return backdrops;
	}


	public void setBackdrops(ArrayList<BackDropDTO> backdrops) {
		this.backdrops = backdrops;
	}

}

