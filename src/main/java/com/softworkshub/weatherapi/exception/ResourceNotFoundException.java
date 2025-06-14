package com.softworkshub.weatherapi.exception;


import lombok.Data;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
