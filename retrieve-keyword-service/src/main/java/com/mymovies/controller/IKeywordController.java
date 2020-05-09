package com.mymovies.controller;

import com.mymovies.dto.KeywordDTO;

import java.util.ArrayList;

public interface IKeywordController {

	ArrayList<KeywordDTO> getAPI_Keyword(String movie_id);
	
}
