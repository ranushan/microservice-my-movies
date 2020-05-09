package com.mymovies.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.mymovies.dto.ReviewDTO;
import com.mymovies.dto.ReviewsDTO;
import com.mymovies.service.IReviewService;

@Controller
@RequestMapping("/review")
@RefreshScope
public class ReviewController implements IReviewController {
	
	@Autowired
	private IReviewService reviewService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReviewController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<ReviewDTO> getAPI_Review(@PathVariable String movie_id) {

		LOGGER.info("@Get Review, id: " + movie_id);

		ReviewsDTO review = null;

		try {
			review = reviewService.getAPI_Review(movie_id);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: getAPI_Reviews: " + e);
		}

		return review.getResults();
	}

}
