package com.mymovies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RetrieveResultsRelease_DatesServiceApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(RetrieveResultsRelease_DatesServiceApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Start Service Results Release Dates");
        SpringApplication.run(RetrieveResultsRelease_DatesServiceApplication.class, args);
    }

}
