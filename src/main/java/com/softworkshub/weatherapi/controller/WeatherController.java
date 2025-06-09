package com.softworkshub.weatherapi.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.softworkshub.weatherapi.model.WeatherResponse;
import com.softworkshub.weatherapi.service.RaterLimiterService;
import com.softworkshub.weatherapi.service.WeatherService;
import io.github.bucket4j.Bucket;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.util.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather/v1")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private RaterLimiterService rateLimiter;

    @GetMapping("/health-check")
    public String health_check() {
        return "OK";
    }

    @GetMapping("/get")
    public ResponseEntity<?> getWeather(
            @RequestParam String city ,
            HttpServletRequest request) {
        String clientIpAddress = request.getRemoteAddr();
        Bucket bucket = rateLimiter.resolveBucket(clientIpAddress);

        if (bucket.tryConsume(1)){
            WeatherResponse weather = weatherService.getWeather(city);
            return new ResponseEntity<>(weather, HttpStatus.OK);
        }else {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                    .body("Too many requests ! Try again in a minute ");
        }

    }
}
