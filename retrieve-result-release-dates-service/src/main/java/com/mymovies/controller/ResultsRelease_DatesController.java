package com.mymovies.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mymovies.dto.Release_DatesDTO;
import com.mymovies.dto.ResultsRelease_DatesDTO;
import com.mymovies.service.IResultsRelease_DatesService;

@Controller
@RequestMapping("/resultsrelease_dates")
@RefreshScope
public class ResultsRelease_DatesController implements IResultsRelease_DatesController {
	
	@Autowired
	private IResultsRelease_DatesService resultsRelease_DatesService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ResultsRelease_DatesController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<ResultsRelease_DatesDTO> getAPI_ResultsRelease_Dates(@PathVariable String movie_id) {

		LOGGER.info("@Get Results Release Dates, id: " + movie_id);

		Release_DatesDTO release_Dates = null;

		try {
			release_Dates = resultsRelease_DatesService.getAPI_ResultsRelease_Dates(movie_id);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: getAPI_ResultsRelease_Dates: " + e);
		}
		
		return release_Dates.getResults();
	}
}
