package com.muni.muni_ecom.exception;

public class ApiException extends RuntimeException {

  private static Long serialVersionUID = 1L;

  public ApiException() {
  }

  public ApiException(String message) {
        super(message);
    }
}
