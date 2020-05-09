package com.mymovies.dto;

import java.util.ArrayList;

public class ImageDTO {

    // Attributs

    private int id;

    private ArrayList<BackdropDTO> backdrops;

    private ArrayList<PosterDTO> posters;


    // Override toString

    @Override
    public String toString() {
        return "ImageDTO [id=" + id + ", backdrops=" + backdrops + ", posters=" + posters + "]";
    }

    // Constructor From SuperClass

    public ImageDTO() {
        super();
    }

    // Constructor Using Fields

    public ImageDTO(int id, ArrayList<BackdropDTO> backdrops, ArrayList<PosterDTO> posters) {
        super();
        this.id = id;
        this.backdrops = backdrops;
        this.posters = posters;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public ArrayList<BackdropDTO> getBackdrops() {
        return backdrops;
    }


    public void setBackdrops(ArrayList<BackdropDTO> backdrops) {
        this.backdrops = backdrops;
    }


    public ArrayList<PosterDTO> getPosters() {
        return posters;
    }


    public void setPosters(ArrayList<PosterDTO> posters) {
        this.posters = posters;
    }

}
