package com.mymovies.dto;

import java.util.ArrayList;

public class MovieDTO {

    private ArrayList<GenreDTO> genres;

    private int id;

    // Override toString

    @Override
    public String toString() {
        return "MovieDTO [genres=" + genres + ", id=" + id + "]";
    }

    // Constructor from SuperClass

    public MovieDTO() {
        super();
    }

    // Constructor Using Fields

    public MovieDTO(ArrayList<GenreDTO> genres, int id) {
        super();
        this.genres = genres;
    }

    // Getters and Setters

    public ArrayList<GenreDTO> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<GenreDTO> genres) {
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}