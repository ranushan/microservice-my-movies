package com.mymovies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@RefreshScope
public class EurekaServerServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(EurekaServerServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Start Service Eureka Server");
		SpringApplication.run(EurekaServerServiceApplication.class, args);
	}

}
