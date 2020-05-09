package com.mymovies.controller;

import java.util.ArrayList;

import com.mymovies.dto.CastDTO;

public interface ICastController {

	public ArrayList<CastDTO> getAPI_Cast(String movie_id);
	
}
