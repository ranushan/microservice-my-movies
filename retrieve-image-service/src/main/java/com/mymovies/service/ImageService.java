package com.mymovies.service;

import com.mymovies.dto.ImageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ImageService implements IImageService {

	@Value("${resource.api.url.base}")
	private String BASE_URL;
	
	@Value("${resource.api.url.image}")
	private String BASE_URL_IMAGE;
	
	@Value("${resource.api.key}")
	private String API_KEY;
	
	@Value("${resource.api.language}")
	private String Language;

	private static final Logger LOGGER = LoggerFactory.getLogger(ImageService.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ImageDTO getAPI_Image(String movie_id) {

		ImageDTO images  = null;
		
		String url = BASE_URL+movie_id+"/images"+API_KEY+Language;
		
		LOGGER.info("@Get getAPI_Image Service URL : " + url);
		
		try {
			images = restTemplate.getForObject(url, ImageDTO.class);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Service: getAPI_Image: " + e);
		}

		return images;

	}

}
