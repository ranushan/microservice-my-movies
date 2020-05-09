package com.mymovies.controller;

import java.util.ArrayList;

import com.mymovies.dto.Spoken_LanguagesDTO;

public interface ISpoken_LanguagesController {

	ArrayList<Spoken_LanguagesDTO> getAPI_Spoken_Languages(String movie_id);
	
}
