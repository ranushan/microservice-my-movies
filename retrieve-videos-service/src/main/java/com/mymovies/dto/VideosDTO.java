package com.mymovies.dto;

import java.util.ArrayList;

public class VideosDTO {

    // Attributs
	
    private int id;

    private ArrayList<VideoDTO> results;

    // Constructor From SuperClass

    public VideosDTO() {
        super();
    }

    // Constructor Using Fields

    public VideosDTO(int id, ArrayList<VideoDTO> results) {
        super();
        this.id = id;
        this.results = results;
    }
    
    // Override toString

    @Override
    public String toString() {
        return "VideosDTO [id=" + id + ", results=" + results + "]";
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public ArrayList<VideoDTO> getResults() {
		return results;
	}

	public void setResults(ArrayList<VideoDTO> results) {
		this.results = results;
	}

}
