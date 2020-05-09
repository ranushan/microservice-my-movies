package com.mymovies.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mymovies.dto.VideosDTO;

@Service
public class VideoService implements IVideoService {

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

	private static final Logger LOGGER = LoggerFactory.getLogger(VideoService.class);
	
	@Autowired
	private RestTemplate restTemplate;

	public VideosDTO getAPI_Video(String movie_id) {

		VideosDTO video = null;
		
		String url = serviceUrl == "" ? BASE_URL+movie_id+"/videos"+API_KEY : serviceUrl+movie_id;
		
		LOGGER.info("@Get getAPI_Video Service URL : " + url);

		try {
			video = restTemplate.getForObject(url, VideosDTO.class);
		} catch (Exception e) {
			LOGGER.error("Unexpected Error From Service: getAPI_Video: " + e);
		}

		return video;

	}
}
