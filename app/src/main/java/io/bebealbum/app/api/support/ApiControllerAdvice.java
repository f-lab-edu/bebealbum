package io.bebealbum.app.api.support;

import io.bebealbum.app.api.support.error.ApiException;
import io.bebealbum.app.api.support.error.ErrorType;
import io.bebealbum.app.api.support.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse<?>> handleCoreApiException(ApiException e) {
        switch (e.getErrorType().getLogLevel()) {
            case ERROR -> log.error("APIException : {}", e.getMessage(), e);
            case WARN -> log.warn("APIException : {}", e.getMessage(), e);
            default -> log.info("APIException : {}", e.getMessage(), e);
        }
        return new ResponseEntity<>(ApiResponse.error(e.getErrorType(), e.getData()), e.getErrorType().getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception e) {
        log.error("Exception : {}", e.getMessage(), e);
        return new ResponseEntity<>(ApiResponse.error(ErrorType.DEFAULT_ERROR), ErrorType.DEFAULT_ERROR.getStatus());
    }

}
