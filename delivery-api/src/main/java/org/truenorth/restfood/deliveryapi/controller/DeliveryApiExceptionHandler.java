package org.truenorth.restfood.deliveryapi.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.truenorth.restfood.deliveryapi.exception.ReviewServiceException;

/**
 * Just an example of web oriented exception handling,  no time for particular behaviour, sorry
 */
@ControllerAdvice
public class DeliveryApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ReviewServiceException.class})
    protected ResponseEntity<Object> handleReviewService(Exception ex, WebRequest request) {
        String bodyOfResponse = String.format("{\"error\": \"%s\"}",ex.getMessage());
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        String bodyOfResponse = String.format("{\"error\": \"%s\"}",ex.getMessage());
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
