package com.training.pizza.exceptions;

import com.training.pizza.exceptions.object.GeneralException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalServicesException {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<GeneralException> exceptionsHandler(ResponseStatusException exception, WebRequest request){
        GeneralException generalException = new GeneralException();
        // move this at custom mapper
        generalException.setTimeStamp(LocalDateTime.now());
        generalException.setStatus(exception.getStatusCode().value());
        generalException.setError(exception.getMessage().substring(0, exception.getMessage().indexOf("\"")));
        generalException.setMessage(exception.getReason());

        return new ResponseEntity<>(generalException, exception.getStatusCode());
    }

}
