package com.gui.schoolsysbackend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid Grade!")
public class InvalidGradeException extends RuntimeException {

    public InvalidGradeException() {
    }

    public InvalidGradeException(String message) {
        super(message);
    }

    public InvalidGradeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidGradeException(Throwable cause) {
        super(cause);
    }

    public InvalidGradeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
