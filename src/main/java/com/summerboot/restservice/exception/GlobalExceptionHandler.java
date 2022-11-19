package com.summerboot.restservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(HttpServletRequest request, Exception ex) {
        if (ex instanceof ApiException) {
            log.warn(ex.getMessage(), ex);
            ApiException apiException = (ApiException) ex;
            ExceptionResponse response = ExceptionResponse.create(apiException.getCode(), apiException.getMessage());
            return new ResponseEntity<ExceptionResponse>(response, apiException.getExceptionEnum().getHttpCode());
        } else {
            log.error(ex.getMessage(), ex);
            ExceptionResponse response = ExceptionResponse.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
            return new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
