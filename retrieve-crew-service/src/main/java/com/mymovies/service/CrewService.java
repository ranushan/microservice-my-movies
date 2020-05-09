package com.mymovies.service;

import com.mymovies.dto.CreditDTO;
import com.mymovies.dto.CrewDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class CrewService implements ICrewService {

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

	private static final Logger LOGGER = LoggerFactory.getLogger(CrewService.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ArrayList<CrewDTO> getAPI_Crew(String movie_id) {

		CreditDTO credits = null;

		String url = serviceUrl == "" ? BASE_URL+movie_id+"/credits"+API_KEY+Language : serviceUrl+movie_id;

		LOGGER.info("@Get getAPI_Crew Service URL : " + url);
		
		try {
			credits = restTemplate.getForObject(url, CreditDTO.class);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Service: getAPI_Crew: " + e);
		}

		return credits.getCrew();

	}

}
