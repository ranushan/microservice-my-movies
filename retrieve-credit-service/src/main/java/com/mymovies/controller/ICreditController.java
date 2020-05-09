package com.mymovies.controller;

import com.mymovies.dto.CreditsDTO;

public interface ICreditController {

	public CreditsDTO getAPI_Credits(String movie_id);

}
