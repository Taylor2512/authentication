package com.monodev.authentication.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.monodev.authentication.config.dto.ActionResult;
import com.monodev.authentication.config.dto.ControllerBase;

@RestControllerAdvice
public class GlobalValidationErrorHandler extends ControllerBase {

    private static final String REQUEST_VALIDATION_ERRORS = "Request validation errors";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ActionResult handleValidationExceptions(MethodArgumentNotValidException ex) {

        List<String> details = new ArrayList<String>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        var stringArray = details.toArray(new String[details.size()]);
        return badRequest(REQUEST_VALIDATION_ERRORS, stringArray);
    }

    
}
