package com.lcdev.restrimais.service.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, WebRequest request) {
        Throwable mostSpecificCause = ex.getMostSpecificCause();
        if (mostSpecificCause instanceof InvalidFormatException) {
            InvalidFormatException invalidFormatException = (InvalidFormatException) mostSpecificCause;
            String errorMessage = String.format("Valor inválido '%s' para o campo '%s'. Valores aceitos: %s",
                    invalidFormatException.getValue(),
                    invalidFormatException.getPath().get(0).getFieldName(),
                    "NUTRITIONIST, REVENUE");

            Map<String, Object> body = new HashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("status", HttpStatus.BAD_REQUEST.value());
            body.put("error", "Bad Request");
            body.put("message", errorMessage);
            body.put("path", request.getDescription(false).substring(4));
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Bad Request");
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).substring(4));
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
