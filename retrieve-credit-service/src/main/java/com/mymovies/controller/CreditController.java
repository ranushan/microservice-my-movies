package com.mymovies.controller;

import com.mymovies.dto.CreditsDTO;
import com.mymovies.service.ICreditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/credit")
@RefreshScope
public class CreditController implements ICreditController {
	
	@Autowired
	private ICreditService creditService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CreditController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public CreditsDTO getAPI_Credits(@PathVariable String movie_id) {

		LOGGER.info("@Get Credits, id: " + movie_id);

		CreditsDTO credits = null;

		try {
			credits = creditService.getAPI_Credit(movie_id);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: getAPI_Credit: " + e);
		}

		return credits;

	}

}
