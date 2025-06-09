package com.softworkshub.weatherapi.service;


import com.softworkshub.weatherapi.model.WeatherResponse;
import org.springframework.http.ResponseEntity;

public interface WeatherService {

    public WeatherResponse getWeather(String city);
}
