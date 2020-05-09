package com.mymovies.controller;

import com.mymovies.dto.KeywordsDTO;
import com.mymovies.service.IKeywordsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/keywords")
@RefreshScope
public class KeywordsController implements IKeywordsController {
	
	@Autowired
	private IKeywordsService keywordsService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KeywordsController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public KeywordsDTO getAPI_Keywords(@PathVariable String movie_id) {

		LOGGER.info("@Get Keywords, id: " + movie_id);

		KeywordsDTO keywords = null;

		try {
			keywords = keywordsService.getAPI_Keywords(movie_id);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: getAPI_Keywords: " + e);
		}

		return keywords;
	}

}
