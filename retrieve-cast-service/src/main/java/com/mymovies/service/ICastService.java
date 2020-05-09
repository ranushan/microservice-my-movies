package com.mymovies.service;

import java.util.ArrayList;

import com.mymovies.dto.CastDTO;

public interface ICastService {
	
	public ArrayList<CastDTO> getAPI_Cast(String movie_id);

}
