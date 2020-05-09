package com.mymovies.service;

import com.mymovies.dto.VideosDTO;

public interface IVideosService {

	VideosDTO getAPI_Videos(String movie_id);
	
}
