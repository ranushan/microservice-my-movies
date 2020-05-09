package com.mymovies.service;

import com.mymovies.dto.MovieDTO;

public interface IMovieService {

	MovieDTO getAPI_Movie(String movie_id);

	String getAPI_MovieDetailAll(String movie_id);

}
