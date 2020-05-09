package com.mymovies.controller;

import com.mymovies.dto.KeywordsDTO;

public interface IKeywordsController {

	KeywordsDTO getAPI_Keywords(String movie_id);
	
}
