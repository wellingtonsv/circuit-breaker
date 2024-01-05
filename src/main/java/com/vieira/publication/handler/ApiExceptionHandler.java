package com.vieira.publication.handler;

import com.vieira.publication.domain.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerMethodException(
            Exception exception,
            HttpServletRequest request
    ){
        ErrorResponse error = ErrorResponse.builder()
                .timestamp(System.currentTimeMillis())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(exception.getMessage())
                .path(request.getRequestURI())
                .build();
        log.error("[ERROR] payload = {}", error, exception);
        return ResponseEntity.internalServerError().body(error);
    }
}
