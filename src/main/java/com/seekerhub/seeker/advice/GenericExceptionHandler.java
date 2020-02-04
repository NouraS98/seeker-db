package com.seekerhub.seeker.advice;

import com.seekerhub.seeker.exception.ApiException;
import com.seekerhub.seeker.exception.GenericException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(value = GenericException.class)
    public ResponseEntity<Object> handleException(GenericException gx) {
        return new ResponseEntity<>(ApiException.builder().status(HttpStatus.BAD_REQUEST.value()).message(gx.getMessage()).errors(gx.getErrors()).build(), HttpStatus.BAD_REQUEST);
    }
}
