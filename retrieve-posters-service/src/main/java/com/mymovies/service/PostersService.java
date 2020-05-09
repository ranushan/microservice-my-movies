package com.mymovies.service;

import com.mymovies.dto.ImageDTO;
import com.mymovies.dto.PostersDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class PostersService implements IPostersService {
	
	@Value("${resource.api.url.base}")
	private String BASE_URL;
	
	@Value("${resource.api.url.image}")
	private String BASE_URL_IMAGE;
	
	@Value("${resource.api.key}")
	private String API_KEY;
	
	@Value("${resource.api.language}")
	private String Language;
	
	@Value("${service.url}")
	private String serviceUrl;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PostersService.class);
	
	@Autowired
	private RestTemplate restTemplate;

	public ArrayList<PostersDTO> retrievePosters(String movie_id) {
	
		ImageDTO images = null;
		
		String url = serviceUrl == "" ? BASE_URL+movie_id+"/images"+API_KEY+Language : serviceUrl+movie_id;

		LOGGER.info("@Get retrievePosters Service URL : " + url);
		
		try {
			images = restTemplate.getForObject(url, ImageDTO.class);
		}catch (Exception e) {
			LOGGER.error("Unexpected Error From Service: retrievePosters: " + e);
		}
		
		return images.getPosters();

	}
	

}
