package com.mymovies.dto;

import java.util.ArrayList;

public class KeywordsDTO {

    // Attributs

    private int id;

    private ArrayList<KeywordDTO> keywords;

    // Override toString

    @Override
    public String toString() {
        return "KeywordsDTO [id=" + id + ", keywords=" + keywords + "]";
    }

    // Constructor From SuperClass

    public KeywordsDTO() {
        super();
    }

    // Constructor Using Fields

    public KeywordsDTO(int id, ArrayList<KeywordDTO> keywords) {
        super();
        this.id = id;
        this.keywords = keywords;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<KeywordDTO> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<KeywordDTO> keywords) {
        this.keywords = keywords;
    }

}
