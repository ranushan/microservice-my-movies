package com.mymovies.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.mymovies.dto.VideoDTO;
import com.mymovies.dto.VideosDTO;
import com.mymovies.service.IVideoService;

@Controller
@RequestMapping("/video")
@RefreshScope
public class VideoController implements IVideoController {
	
	@Autowired
	private IVideoService videoService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VideoController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<VideoDTO> getAPI_Video(@PathVariable String movie_id) {

		LOGGER.info("@Get Video, id: " + movie_id);

		VideosDTO video = null;

		try {
			video = videoService.getAPI_Video(movie_id);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: getAPI_Video: " + e);
		}

		return video.getResults();
	}
}
