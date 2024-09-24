package com.fatih.recipeBook.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(DataAlreadyExistException.class)
  public ResponseEntity<ErrorResponse> globalEmailAlreadyExistsException(
      DataAlreadyExistException dataAlreadyExistException, WebRequest webRequest)
  {
    ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), dataAlreadyExistException.getMessage(), new Date());

    return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorResponse> resourceNotFoundException(
      ResourceNotFoundException resourceNotFoundException, WebRequest webRequest)
  {
    ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), resourceNotFoundException.getMessage(), new Date());

    return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
  }
}