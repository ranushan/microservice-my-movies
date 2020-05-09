package com.mymovies.controller;

import com.mymovies.dto.CrewDTO;

import java.util.ArrayList;

public interface ICrewController {

	public ArrayList<CrewDTO> getAPI_Crew(String movie_id);
	
}
