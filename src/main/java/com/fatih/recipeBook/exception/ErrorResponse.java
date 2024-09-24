package com.fatih.recipeBook.exception;

import java.util.Date;

public class ErrorResponse {

  private Integer errorCode;
  private String errorMessage;
  private Date dateTime;

  public ErrorResponse(Integer errorCode, String errorMessage, Date dateTime) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
    this.dateTime = dateTime;
  }

  public Integer getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }
}
