package com.mymovies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RetrieveCrewServiceApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(RetrieveCrewServiceApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Start Service Crew");
        SpringApplication.run(RetrieveCrewServiceApplication.class, args);
    }

}
