package com.seekerhub.seeker.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Data
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GenericException extends RuntimeException {

    private List<ApiError> errors;

    public GenericException(String message) {
        super(message);
    }

    public GenericException(String message, List<ApiError> errors) {
        super(message);
        this.errors = errors;
    }
}
