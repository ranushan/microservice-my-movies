package com.mymovies.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.mymovies.dto.ReviewsDTO;
import com.mymovies.service.IReviewsService;

@Controller
@RequestMapping("/reviews")
@RefreshScope
public class ReviewsController implements IReviewsController {
	
	@Autowired
	private IReviewsService reviewsService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReviewsController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ReviewsDTO getAPI_Reviews(@PathVariable String movie_id) {

		LOGGER.info("@Get Reviews, id: " + movie_id);

		ReviewsDTO reviews = null;

		try {
			reviews = reviewsService.getAPI_Reviews(movie_id);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: getAPI_Reviews: " + e);
		}

		return reviews;
	}

}
