package com.mymovies.service;

import com.mymovies.dto.KeywordsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KeywordService implements IKeywordService {

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

	private static final Logger LOGGER = LoggerFactory.getLogger(KeywordService.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	public KeywordsDTO getAPI_Keyword(String movie_id) {

		KeywordsDTO listOfKeywords = null;
		
		String url = serviceUrl == "" ? BASE_URL+movie_id+"/keywords"+API_KEY+Language : serviceUrl+movie_id;
		
		LOGGER.info("@Get getAPI_Keyword Service URL : " + url);

		try {
			listOfKeywords = restTemplate.getForObject(url, KeywordsDTO.class);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Service: getAPI_Keyword: " + e);
		}

		return listOfKeywords;

	}

}
