package com.mymovies.controller;

import com.mymovies.dto.MovieDTO;
import com.mymovies.dto.Spoken_LanguagesDTO;
import com.mymovies.service.ISpoken_LanguagesService;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/spoken_languages")
@RefreshScope
public class Spoken_LanguagesController implements ISpoken_LanguagesController {
	
	@Autowired
	private ISpoken_LanguagesService spoken_languagesService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Spoken_LanguagesController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Spoken_LanguagesDTO> getAPI_Spoken_Languages(@PathVariable String movie_id) {

		LOGGER.info("@Get Spoken_Languages, id: " + movie_id);

		MovieDTO movie = null;

		try {
			movie = spoken_languagesService.getAPI_Spoken_Languages(movie_id);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: getAPI_Movie: " + e);
		}

		return movie.getSpoken_languages();
	}
}
