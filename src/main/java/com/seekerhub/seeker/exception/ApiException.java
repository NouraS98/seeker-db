package com.seekerhub.seeker.exception;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ApiException {
    private int status;
    private String message;
    private List<ApiError> errors;
}
