package com.mymovies.controller;

import com.mymovies.service.IDiscoverService;
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

@Controller
@RequestMapping("/discover")
@RefreshScope
public class DiscoverController implements IDiscoverController {
	
	@Autowired
	private IDiscoverService discoverService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DiscoverController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/{page_number}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getAPI_Discover(@PathVariable String page_number) {

		LOGGER.info("@Get Discover, page Number: " + page_number);

		String listOfMovies = null;

		try {
			listOfMovies = discoverService.getAPI_Discover(page_number);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: getAPI_Discover: " + e);
		}

		return listOfMovies;
	}

}
