package com.mymovies.controller;

import com.mymovies.dto.VideosDTO;

public interface IVideosController {

	VideosDTO getAPI_Videos(String movie_id);
	
}
