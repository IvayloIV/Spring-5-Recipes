package com.example.demo.web;

import com.example.demo.exceptions.PlayerNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingAdvice {

    @ExceptionHandler(PlayerNotFoundException.class)
    public String handle(PlayerNotFoundException ex) {
        return "playerNotFound";
    }

    @ExceptionHandler
    public String catchException(Exception ex) {
        return "error";
    }
}
