package com.softworkshub.weatherapi.service.impl;

import com.softworkshub.weatherapi.model.WeatherResponse;
import com.softworkshub.weatherapi.service.RedisService;
import com.softworkshub.weatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {


    private static final String API_KEY = "your_api_key";

    // Base url ->  http://api.weatherapi.com/v1

    private static final String BaseUrl =
            "http://api.weatherapi.com/v1/current.json?key=api_key&q=Delhi&aqi=no";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisService redisService;


    @Override
    public WeatherResponse getWeather(String city) {
        WeatherResponse weatherResponse = redisService.get("weather_of_" + city, WeatherResponse.class);
        if (weatherResponse != null) {
            return weatherResponse;
        } else {
            String url = BaseUrl.replace("Delhi", city).replace("api_key", API_KEY);
            ResponseEntity<WeatherResponse> exchange = restTemplate.exchange(url, HttpMethod.GET, null, WeatherResponse.class);
            WeatherResponse body = exchange.getBody();
            redisService.set("weather_of_" + city, body, 300L);
            return body;
        }
    }
}
