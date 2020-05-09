package com.mymovies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.mymovies.filter.ErrorFilter;
import com.mymovies.filter.PostFilter;
import com.mymovies.filter.PreFilter;
import com.mymovies.filter.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@RefreshScope
public class ZuulApiGatewayServiceApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZuulApiGatewayServiceApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Start Service Zuul API Gateway");
        SpringApplication.run(ZuulApiGatewayServiceApplication.class, args);
    }
	
    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }

    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }

    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }
}
