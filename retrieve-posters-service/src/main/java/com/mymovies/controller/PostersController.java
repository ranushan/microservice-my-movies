package com.mymovies.controller;

import java.util.ArrayList;

import com.mymovies.dto.PostersDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.mymovies.service.IPostersService;


@Controller
@RequestMapping("/posters")
@RefreshScope
public class PostersController implements IPostersController {

	@Autowired
	private IPostersService postersService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PostersController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<PostersDTO> retrievePosters(@PathVariable String movie_id) {
		
		LOGGER.info("@Get Posters, id: " + movie_id);

		ArrayList<PostersDTO> listOfPosters = null;

		try {
			listOfPosters = postersService.retrievePosters(movie_id);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: retrievePosters: " + e);
		}

		return listOfPosters;
		
	}

}
