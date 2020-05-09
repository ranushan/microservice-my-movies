package com.mymovies.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mymovies.dto.VideosDTO;

@Service
public class VideosService implements IVideosService {

	@Value("${resource.api.url.base}")
	private String BASE_URL;
	
	@Value("${resource.api.url.image}")
	private String BASE_URL_IMAGE;
	
	@Value("${resource.api.key}")
	private String API_KEY;
	
	@Value("${resource.api.language}")
	private String Language;

	private static final Logger LOGGER = LoggerFactory.getLogger(VideosService.class);
	
	@Autowired
	private RestTemplate restTemplate;

	public VideosDTO getAPI_Videos(String movie_id) {

		VideosDTO listOfvideos = null;
		
		String url = BASE_URL+movie_id+"/videos"+API_KEY;
		
		LOGGER.info("@Get getAPI_Videos Service URL : " + url);
		
		try {
			listOfvideos = restTemplate.getForObject(url, VideosDTO.class);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Service: getAPI_Videos: " + e);
		}

		return listOfvideos;

	}
}
