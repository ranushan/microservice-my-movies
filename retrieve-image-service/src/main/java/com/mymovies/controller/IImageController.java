package com.mymovies.controller;

import com.mymovies.dto.ImageDTO;

public interface IImageController {

	public ImageDTO getAPI_Image(String movie_id);
	
}
