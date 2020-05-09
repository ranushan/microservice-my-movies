package com.mymovies.service;

import com.mymovies.dto.CrewDTO;

import java.util.ArrayList;

public interface ICrewService {
	
	public ArrayList<CrewDTO> getAPI_Crew(String movie_id);

}
