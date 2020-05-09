package com.mymovies.service;

import com.mymovies.dto.MovieDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Production_CountriesService implements IProduction_CountriesService {

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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Production_CountriesService.class);
	
	@Autowired
	private RestTemplate restTemplate;

	public MovieDTO getAPI_Production_Countries(String movie_id) {

		MovieDTO movie = null;
		
		String url = serviceUrl == "" ? BASE_URL+movie_id+API_KEY+Language : serviceUrl+movie_id;
		
		LOGGER.info("@Get getAPI_Production_Countries Service URL : " + url);

		try {

			movie = restTemplate.getForObject(url, MovieDTO.class);

		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Service: getAPI_Production_Countries: " + e);
		}

		return movie;

	}

}
