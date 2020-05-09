package com.mymovies.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DiscoverService implements IDiscoverService {

	@Value("${service.url}")
	private String serviceUrl;

	private static final Logger LOGGER = LoggerFactory.getLogger(DiscoverService.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String getAPI_Discover(String page_number) {

		String discover = null;

		String url = serviceUrl;
		
		LOGGER.info("@Get getAPI_Discover Service URL : " + url);
				
		try {
			discover = restTemplate.getForObject(url+page_number, String.class);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Service: getAPI_Discover: " + e);
		}

		return discover;

	}

}