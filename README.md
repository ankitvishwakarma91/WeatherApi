# 🌦️ Weather API Microservice

This is a Spring Boot-based microservice developed by **Ankit Vishwakarma** that fetches real-time weather information for a given city using the [WeatherAPI](https://www.weatherapi.com/). The service includes:

- 🔁 Integration with Redis for caching responses
- 🔐 Structure ready for rate-limiting implementation (single server)
- 🌍 Third-party API consumption via `RestTemplate`
- ☁️ RESTful API endpoints with proper response handling



## 🔧 Technologies Used

- ✅ **Java 17**
- ✅ **Spring Boot 3.x**
- ✅ **Spring Web**
- ✅ **Spring Data Redis**
- ✅ **Lombok**
- ✅ **Redis (local)**
- ✅ **RestTemplate**
- ✅ **Bucket4j for Rate Limiting**

# 🧠 Features Implemented

### ✅ 1. Get Weather Data

Fetches real-time weather info using external API and caches it:

```http
GET /weather/v1/get?city=Delhi
```
```Response  
{
  "location": {
    "name": "Delhi",
    "region": "Delhi",
    "country": "India",
    "localtime": "2025-06-09 10:00"
  },
  "current": {
    "temp_c": 33.0,
    "condition": {
      "text": "Partly cloudy",
      "icon": "//cdn.weatherapi.com/weather/64x64/day/116.png"
    },
    "humidity": 54,
    "wind_kph": 14.4
  }
}
```

  **Author**
  **Ankit Vishwakarma** 

