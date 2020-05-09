package com.mymovies.service;

import com.mymovies.dto.CreditsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CreditService implements ICreditService {

	@Value("${resource.api.url.base}")
	private String BASE_URL;
	
	@Value("${resource.api.url.image}")
	private String BASE_URL_IMAGE;
	
	@Value("${resource.api.key}")
	private String API_KEY;
	
	@Value("${resource.api.language}")
	private String Language;

	private static final Logger LOGGER = LoggerFactory.getLogger(CreditService.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public CreditsDTO getAPI_Credit(String movie_id) {

		CreditsDTO credits = null;

		String url = BASE_URL+movie_id+"/credits"+API_KEY+Language;

		LOGGER.info("@Get getAPI_Credit Service URL : " + url);
		
		try {
			credits = restTemplate.getForObject(url, CreditsDTO.class);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Service: getAPI_Credit: " + e);
		}

		return credits;

	}

}
