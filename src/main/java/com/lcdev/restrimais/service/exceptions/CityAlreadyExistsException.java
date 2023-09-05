package com.lcdev.restrimais.service.exceptions;

public class CityAlreadyExistsException extends RuntimeException{

    public CityAlreadyExistsException(String msg){
        super(msg);
    }
}
