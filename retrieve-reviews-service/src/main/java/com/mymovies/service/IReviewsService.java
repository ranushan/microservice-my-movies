package com.mymovies.service;

import com.mymovies.dto.ReviewsDTO;

public interface IReviewsService {

	ReviewsDTO getAPI_Reviews(String movie_id);

}
