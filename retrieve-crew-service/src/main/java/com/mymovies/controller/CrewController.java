package com.mymovies.controller;

import com.mymovies.dto.CrewDTO;
import com.mymovies.service.ICrewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/crew")
@RefreshScope
public class CrewController implements ICrewController {
	
	@Autowired
	private ICrewService crewService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CrewController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<CrewDTO> getAPI_Crew(@PathVariable String movie_id) {

		LOGGER.info("@Get Crew, id: " + movie_id);

		ArrayList<CrewDTO> listOfCrew = null;

		try {
			listOfCrew = crewService.getAPI_Crew(movie_id);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: getAPI_Crew: " + e);
		}

		return listOfCrew;
	}

}
