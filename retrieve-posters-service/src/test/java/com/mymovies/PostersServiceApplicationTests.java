package com.mymovies;

import java.io.IOException;
import java.util.Properties;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostersServiceApplicationTests {
	
	Properties properties = new Properties();

	{
	    try {
	      properties.load(getClass().getResourceAsStream("/application.properties"));
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	}

	
	@Test
	void contextLoads() {
		
		Assertions.assertThat(
				properties.getProperty("resource.api.url"))
				.isEqualTo("https://api.themoviedb.org/3/movie/");
		
		Assertions.assertThat(
				properties.getProperty("resource.api.url.image"))
				.isEqualTo("https://image.tmbd.org/t/p/w342");
		
		Assertions.assertThat(
				properties.getProperty("resource.api.key"))
				.isEqualTo("?api_key=0a2eea61408ba5facdd057f7d11d2f58");
		
		Assertions.assertThat(
				properties.getProperty("resource.api.language"))
				.isEqualTo("&language=fr-FR");
		
	}

}
