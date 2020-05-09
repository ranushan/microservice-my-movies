package com.mymovies.controller;

import com.mymovies.dto.ImageDTO;
import com.mymovies.service.IImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/image")
@RefreshScope
public class ImageController implements IImageController {
	
	@Autowired
	private IImageService imageService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ImageController.class);
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/{movie_id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ImageDTO getAPI_Image(@PathVariable String movie_id) {

		LOGGER.info("@Get Image, id: " + movie_id);

		ImageDTO image = null;

		try {
			image = imageService.getAPI_Image(movie_id);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Controller: getAPI_Image: " + e);
		}

		return image;
	}

}
