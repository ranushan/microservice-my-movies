package com.mymovies.controller;

import com.mymovies.dto.MovieDTO;

public interface IMovieController {

	MovieDTO getAPI_Movie(String movie_id);

	String getAPI_MovieDetailAll(String movie_id);
	
}
