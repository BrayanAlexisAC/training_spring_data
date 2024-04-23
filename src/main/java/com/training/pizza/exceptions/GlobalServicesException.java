package com.training.pizza.exceptions;

import com.training.pizza.domain.mappers.GeneralExceptionMapper;
import com.training.pizza.exceptions.object.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalServicesException {

    @Autowired
    GeneralExceptionMapper mapper;

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<GeneralException> responseStatusExceptionHandler(ResponseStatusException exception){
        return new ResponseEntity<>(mapper.toGeneralException(exception), exception.getStatusCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GeneralException> argumentNotValidExceptionHandler(MethodArgumentNotValidException argumentException){
        return new ResponseEntity<>(mapper.toGeneralException(argumentException), argumentException.getStatusCode());
    }

}
