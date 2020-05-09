package com.mymovies.controller;

import com.mymovies.dto.MovieDTO;
import com.mymovies.service.IMovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movie")
@RefreshScope
public class MovieController implements IMovieController {
	
	@Autowired
	private IMovieService movieService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public MovieDTO getAPI_Movie(@PathVariable String movie_id) {

		LOGGER.info("@Get Movie, id: " + movie_id);

		MovieDTO movie = null;

		try {
			movie = movieService.getAPI_Movie(movie_id);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: getAPI_Movie: " + e);
		}

		return movie;
	}

	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/all/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getAPI_MovieDetailAll(@PathVariable String movie_id) {

		LOGGER.info("@Get Movie, id: " + movie_id);

		String movie = null;

		try {
			movie = movieService.getAPI_MovieDetailAll(movie_id);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: getAPI_MovieDetailAll: " + e);
		}

		return movie;

	}

}
