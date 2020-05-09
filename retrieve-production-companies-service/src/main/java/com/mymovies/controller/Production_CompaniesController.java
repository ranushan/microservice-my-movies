package com.mymovies.controller;

import com.mymovies.dto.MovieDTO;
import com.mymovies.dto.Production_CompaniesDTO;
import com.mymovies.service.IProduction_CompaniesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/production_companies")
@RefreshScope
public class Production_CompaniesController implements IProduction_CompaniesController {
	
	@Autowired
	private IProduction_CompaniesService production_companiesService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Production_CompaniesController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Production_CompaniesDTO> getAPI_Production_Companies(@PathVariable String movie_id) {

		LOGGER.info("@Get Production_Companies, id: " + movie_id);

		MovieDTO movie = null;

		try {
			movie = production_companiesService.getAPI_Production_Companies(movie_id);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: getAPI_Production_Companies: " + e);
		}

		return movie.getProduction_companies();
	}

}
