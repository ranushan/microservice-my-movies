package com.mymovies.controller;

import java.util.ArrayList;

import com.mymovies.dto.ReviewDTO;

public interface IReviewController {

	ArrayList<ReviewDTO> getAPI_Review(String movie_id);
	
}
