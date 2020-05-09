package com.mymovies.service;

import com.mymovies.dto.CreditsDTO;

public interface ICreditService {
	
	public CreditsDTO getAPI_Credit(String movie_id);

}
