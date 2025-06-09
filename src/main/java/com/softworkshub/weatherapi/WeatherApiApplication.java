package com.softworkshub.weatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WeatherApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherApiApplication.class, args);
        System.out.println("Hello Weather API!");
    }

    @Bean
    public RestTemplate restTemplate() {
        return  new RestTemplate();
    }

}
