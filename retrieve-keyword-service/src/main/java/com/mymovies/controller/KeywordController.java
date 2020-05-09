package com.mymovies.controller;

import com.mymovies.dto.KeywordDTO;
import com.mymovies.dto.KeywordsDTO;
import com.mymovies.service.IKeywordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/keyword")
@RefreshScope
public class KeywordController implements IKeywordController {
	
	@Autowired
	private IKeywordService keywordService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KeywordController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<KeywordDTO> getAPI_Keyword(@PathVariable String movie_id) {

		LOGGER.info("@Get Keyword, id: " + movie_id);

		KeywordsDTO keywords = null;

		try {
			keywords = keywordService.getAPI_Keyword(movie_id);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: getAPI_Keyword: " + e);
		}

		return keywords.getKeywords();
	}

}
