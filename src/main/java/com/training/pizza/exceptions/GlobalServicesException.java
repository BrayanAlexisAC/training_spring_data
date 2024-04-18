package com.training.pizza.exceptions;

import com.training.pizza.exceptions.object.GeneralException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalServicesException {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<GeneralException> responseStatusExceptionHandler(ResponseStatusException exception, WebRequest request){
        GeneralException generalException = new GeneralException();
        // move this at custom mapper
        generalException.setTimeStamp(LocalDateTime.now());
        generalException.setStatus(exception.getStatusCode().value());
        generalException.setError(exception.getMessage().substring(0, exception.getMessage().indexOf("\"")));
        generalException.setMessage(exception.getReason());

        return new ResponseEntity<>(generalException, exception.getStatusCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GeneralException> argumentNotValidExceptionHandler(MethodArgumentNotValidException argumentException){
        GeneralException generalException = new GeneralException();
        // move this at custom mapper
        generalException.setTimeStamp(LocalDateTime.now());
        generalException.setStatus(argumentException.getStatusCode().value());
        generalException.setMessage("Error with fields: ");

        Map<String,String> mapErrors = argumentException.getAllErrors().stream().collect(
                Collectors.toMap(
                    errorKey -> {
                        String fieldName = ((FieldError) errorKey).getField();
                        generalException.setMessage(generalException.getMessage() + fieldName + ", ");
                        return fieldName;
                    },
                    errorValue -> Optional.ofNullable(errorValue.getDefaultMessage()).orElse("")
                )
        );

        generalException.setErrorsDetail(mapErrors);
        return new ResponseEntity<>(generalException, argumentException.getStatusCode());
    }

}
