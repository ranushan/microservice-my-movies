package com.mymovies.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.mymovies.dto.BackDropDTO;
import com.mymovies.service.IBackDropService;


@Controller
@RequestMapping("/backdrop")
@RefreshScope
public class BackDropController implements IBackDropController {

	@Autowired
	private IBackDropService backdropService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BackDropController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<BackDropDTO> retrieveBackDrop(@PathVariable String movie_id) {
		
		LOGGER.info("@Get BackDrop, id: " + movie_id);

		ArrayList<BackDropDTO> listOfBackDrop = null;

		try {
			listOfBackDrop = backdropService.retrieveBackDrop(movie_id);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: retrieveBackDrop: " + e);
		}

		return listOfBackDrop;
		
	}

}
