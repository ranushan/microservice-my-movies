package com.mymovies.service;

import com.mymovies.dto.ListGenresAvailableDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ListGenresAvailableService implements IListGenresAvailableService {

	@Value("${resource.api.url.base}")
	private String BASE_URL;
	
	@Value("${resource.api.url.image}")
	private String BASE_URL_IMAGE;
	
	@Value("${resource.api.key}")
	private String API_KEY;
	
	@Value("${resource.api.language}")
	private String Language;

	private static final Logger LOGGER = LoggerFactory.getLogger(ListGenresAvailableService.class);
	
	@Autowired
	private RestTemplate restTemplate;

	public ListGenresAvailableDTO getAPI_ListGenresAvailable() {

		ListGenresAvailableDTO listGenresAvailable = null;
		
		String url = BASE_URL+API_KEY+Language;
		
		LOGGER.info("@Get getAPI_ListGenresAvailable Service URL : " + url);

		try {
			listGenresAvailable = restTemplate.getForObject(url, ListGenresAvailableDTO.class);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Service: getAPI_ListGenresAvailable: " + e);
		}

		return listGenresAvailable;

	}

}
