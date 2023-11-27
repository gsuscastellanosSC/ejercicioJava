package com.ejerciciojava.microservicio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FactorialExeption extends RuntimeException {
  public FactorialExeption  (String message) {
        super(message);
    }
}
