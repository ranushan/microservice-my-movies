package com.mymovies.controller;

import com.mymovies.dto.Production_CountriesDTO;

import java.util.ArrayList;

public interface IProduction_CountriesController {

	ArrayList<Production_CountriesDTO> getAPI_Production_Countries(String movie_id);


}
