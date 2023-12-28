package com.microservices.orderservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced //create a load-balanced client

    //injected into other components to create instances of WebClient for making HTTP request
    //WebClient is a non-blocking, reactive web client introduced in Spring WebFlux.
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }
}
