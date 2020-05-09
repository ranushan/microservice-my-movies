package com.mymovies.controller;

import java.util.ArrayList;

import com.mymovies.dto.VideoDTO;

public interface IVideoController {

	ArrayList<VideoDTO> getAPI_Video(String movie_id);

}
