package com.mymovies.controller;

import com.mymovies.dto.Production_CompaniesDTO;

import java.util.ArrayList;

public interface IProduction_CompaniesController {

	ArrayList<Production_CompaniesDTO> getAPI_Production_Companies(String movie_id);


}
