package com.mymovies.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.mymovies.dto.VideosDTO;
import com.mymovies.service.IVideosService;

@Controller
@RequestMapping("/videos")
@RefreshScope
public class VideosController implements IVideosController {
	
	@Autowired
	private IVideosService videosService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VideosController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public VideosDTO getAPI_Videos(@PathVariable String movie_id) {

		LOGGER.info("@Get Videos, id: " + movie_id);

		VideosDTO videos = null;

		try {
			videos = videosService.getAPI_Videos(movie_id);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: getAPI_Videos: " + e);
		}

		return videos;
	}
	
}
