package com.lcdev.restrimais.service.exceptions;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String msg){
        super(msg);
    }
}
