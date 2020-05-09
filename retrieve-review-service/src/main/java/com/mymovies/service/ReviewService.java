package com.mymovies.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mymovies.dto.ReviewsDTO;

@Service
public class ReviewService implements IReviewService {

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

	private static final Logger LOGGER = LoggerFactory.getLogger(ReviewService.class);
	
	@Autowired
	private RestTemplate restTemplate;

	public ReviewsDTO getAPI_Review(String movie_id) {

		ReviewsDTO reviews = null;
		
		String url = serviceUrl == "" ? BASE_URL+movie_id+"/reviews"+API_KEY : serviceUrl+movie_id;
		
		LOGGER.info("@Get getAPI_Review Service URL : " + url);

		try {

			reviews = restTemplate.getForObject(url, ReviewsDTO.class);

		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Service: getAPI_Review: " + e);
		}

		return reviews;

	}

}
