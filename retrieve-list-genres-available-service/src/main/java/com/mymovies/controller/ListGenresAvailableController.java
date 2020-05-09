package com.mymovies.controller;

import com.mymovies.dto.GenreDTO;
import com.mymovies.dto.ListGenresAvailableDTO;
import com.mymovies.service.IListGenresAvailableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RefreshScope
public class ListGenresAvailableController implements IListGenresAvailableController {
	
	@Autowired
	private IListGenresAvailableService listGenresAvailableService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ListGenresAvailableController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/listgenres", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<GenreDTO> getAPI_ListGenresAvailable() {

		LOGGER.info("@Get List Genres Available");

		ListGenresAvailableDTO listGenresAvailable = null;

		try {
			listGenresAvailable = listGenresAvailableService.getAPI_ListGenresAvailable();
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: getAPI_ListGenresAvailable: " + e);
		}

		return listGenresAvailable.getGenres();
	}

}
