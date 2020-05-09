package com.mymovies.controller;

import com.mymovies.dto.GenreDTO;

import java.util.ArrayList;

public interface IListGenresAvailableController {

	ArrayList<GenreDTO> getAPI_ListGenresAvailable();
	
}
