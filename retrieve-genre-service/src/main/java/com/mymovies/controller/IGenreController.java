package com.mymovies.controller;

import com.mymovies.dto.GenreDTO;

import java.util.ArrayList;

public interface IGenreController {

	public ArrayList<GenreDTO> getAPI_Genre(String movie_id);
	
}
