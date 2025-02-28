package io.darasa.dwhsnew.exception;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Hidden
@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler({ElasticsearchException.class})
    public ResponseEntity<String> handleException(ElasticsearchException exception) {
        return buildErrorResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<String> handleException(InvalidRequestException exception) {
        return buildErrorResponse(exception, HttpStatus.BAD_REQUEST);
    }

    private static ResponseEntity<String> buildErrorResponse(Exception exception, HttpStatus status) {
        log.error("ApiException occurred at due to: {}", exception.toString(), exception);
        return ResponseEntity.status(status).body(exception.getMessage());
    }
}
