package com.mymovies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
@RefreshScope
public class ConfigServerServiceApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigServerServiceApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Start Service Config Server");
        SpringApplication.run(ConfigServerServiceApplication.class, args);
    }

}
