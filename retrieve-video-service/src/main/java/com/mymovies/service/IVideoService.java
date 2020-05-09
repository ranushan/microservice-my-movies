package com.mymovies.service;

import com.mymovies.dto.VideosDTO;

public interface IVideoService {

	VideosDTO getAPI_Video(String movie_id);

}
