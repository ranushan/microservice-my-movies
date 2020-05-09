package com.mymovies.service;

import com.mymovies.dto.ReviewsDTO;

public interface IReviewService {

	ReviewsDTO getAPI_Review(String movie_id);

}
