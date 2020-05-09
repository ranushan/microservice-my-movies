package com.mymovies.service;

import com.mymovies.dto.GenreDTO;

import java.util.ArrayList;

public interface IGenreService {
	
	public ArrayList<GenreDTO> getAPI_Genre(String movie_id);

}
