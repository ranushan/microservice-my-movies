package com.mymovies.controller;

import java.util.ArrayList;

import com.mymovies.dto.ResultsRelease_DatesDTO;

public interface IResultsRelease_DatesController {

	ArrayList<ResultsRelease_DatesDTO> getAPI_ResultsRelease_Dates(String movie_id);
	
}
