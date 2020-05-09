package com.mymovies.dto;

import java.util.ArrayList;

public class ListGenresAvailableDTO {

    // Attributs
    private ArrayList<GenreDTO> genres;

    // Override toString

    @Override
    public String toString() {
        return "ListGenresAvailableDTO [genres=" + genres + "]";
    }

    // Constructor From SuperClass

    public ListGenresAvailableDTO() {
        super();
    }

    // Constructor Using Fields

    public ListGenresAvailableDTO(ArrayList<GenreDTO> genres) {
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

}