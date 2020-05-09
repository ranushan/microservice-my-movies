package com.mymovies.controller;

import com.mymovies.dto.ReviewsDTO;

public interface IReviewsController {

	ReviewsDTO getAPI_Reviews(String movie_id);
	
}
