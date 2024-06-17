package com.lcdev.restrimais.service.exceptions;

public class InvalidAssessmentTypeException extends RuntimeException{
    public InvalidAssessmentTypeException(String msg){
        super(msg);
    }
}
