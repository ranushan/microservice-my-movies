package com.mymovies.dto;

import java.util.ArrayList;

public class ImageDTO {

	// Attributs
	
	private int id;
	
	private ArrayList<PostersDTO> posters;
	
	// Override toString
	
	@Override
	public String toString() {
		return "ImageDTO [id=" + id + ", posters=" + posters + "]";
	}

	// Constructor From SuperClass
	
	public ImageDTO() {
		super();
	}

	// Constructor Using Fields

	public ImageDTO(int id, ArrayList<PostersDTO> posters) {
		super();
		this.id = id;
		this.posters = posters;
	}

	// Getters and Setters

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public ArrayList<PostersDTO> getPosters() {
		return posters;
	}


	public void setPosters(ArrayList<PostersDTO> posters) {
		this.posters = posters;
	}

}

