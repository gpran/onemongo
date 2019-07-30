package com.student.onemongo.customexception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Initialising")
public class NPExcp extends ResponseEntityExceptionHandler{

        @ExceptionHandler(NullPointerException.class)
        public final ResponseEntity<ErrorDetails> handleInvalidFormatException(InvalidFormatException ex, WebRequest request) {

            ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),

                    request.getDescription(false));
            System.out.println(new Date() + "\t" + ex.getMessage());
            return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

        }

    }
