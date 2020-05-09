package com.mymovies.controller;

import com.mymovies.dto.MovieDTO;
import com.mymovies.dto.Production_CountriesDTO;
import com.mymovies.service.IProduction_CountriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/production_countries")
@RefreshScope
public class Production_CountriesController implements IProduction_CountriesController {
	
	@Autowired
	private IProduction_CountriesService production_countriesService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Production_CountriesController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Production_CountriesDTO> getAPI_Production_Countries(@PathVariable String movie_id) {

		LOGGER.info("@Get Production_Countries, id: " + movie_id);

		MovieDTO movie = null;

		try {
			movie = production_countriesService.getAPI_Production_Countries(movie_id);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: getAPI_Production_Countries: " + e);
		}

		return movie.getProduction_countries();
	}

}
