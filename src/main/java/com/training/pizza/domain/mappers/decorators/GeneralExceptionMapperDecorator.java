package com.training.pizza.domain.mappers.decorators;

import com.training.pizza.domain.mappers.GeneralExceptionMapper;
import com.training.pizza.exceptions.object.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GeneralExceptionMapperDecorator implements GeneralExceptionMapper {

    @Autowired
    @Qualifier("delegate")
    private GeneralExceptionMapper mapper;

    @Override
    public GeneralException toGeneralException(ResponseStatusException responseStatusException) {
        GeneralException generalException = mapper.toGeneralException(responseStatusException);

        generalException.setStatus(responseStatusException.getStatusCode().value());
        generalException.setError(responseStatusException.getMessage().substring(0, responseStatusException.getMessage().indexOf("\"")));

        return generalException;
    }

    @Override
    public GeneralException toGeneralException(MethodArgumentNotValidException argumentException) {
        GeneralException generalException = mapper.toGeneralException(argumentException);

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

        return generalException;
    }
}
