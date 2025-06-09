package com.softworkshub.weatherapi.service;


import lombok.Data;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTests {

    @Autowired
    private RedisTemplate redisTemplate;


    @Disabled
    @Test
    void testRedisMessage(){
        redisTemplate.opsForValue().set("email","ankit@gmail.com");

        Object email = redisTemplate.opsForValue().get("email");
        int a = 1;
    }

}
