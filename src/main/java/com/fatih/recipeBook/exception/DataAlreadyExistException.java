package com.fatih.recipeBook.exception;

public class DataAlreadyExistException extends RuntimeException {
  public DataAlreadyExistException(String message) {
    super(message);
  }
}
