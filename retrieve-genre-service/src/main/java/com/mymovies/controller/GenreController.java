package com.mymovies.controller;

import com.mymovies.dto.GenreDTO;
import com.mymovies.service.IGenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/genre")
@RefreshScope
public class GenreController implements IGenreController {
	
	@Autowired
	private IGenreService genreService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GenreController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<GenreDTO> getAPI_Genre(@PathVariable String movie_id) {

		LOGGER.info("@Get Genre, id: " + movie_id);

		ArrayList<GenreDTO> listOfGenre = null;

		try {
			listOfGenre = genreService.getAPI_Genre(movie_id);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: getAPI_Genre: " + e);
		}

		return listOfGenre;
	}

}
