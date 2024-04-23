package com.training.pizza.domain.mappers;

import com.training.pizza.domain.mappers.decorators.GeneralExceptionMapperDecorator;
import com.training.pizza.exceptions.object.GeneralException;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.server.ResponseStatusException;

@Mapper(componentModel = "spring")
@DecoratedWith(GeneralExceptionMapperDecorator.class)
public interface GeneralExceptionMapper {

    @Mappings({
            @Mapping(target = "timeStamp", expression = "java(java.time.LocalDateTime.now())"),
            @Mapping(source = "reason", target = "message"),
            @Mapping(target = "status", ignore = true),
            @Mapping(target = "error", ignore = true),
            @Mapping(target = "errorsDetail", ignore = true)
    })
    GeneralException toGeneralException(ResponseStatusException responseStatusException);

    @Mappings({
            @Mapping(target = "timeStamp", expression = "java(java.time.LocalDateTime.now())"),
            @Mapping(target = "message", ignore = true),
            @Mapping(target = "status", ignore = true),
            @Mapping(target = "error", ignore = true),
            @Mapping(target = "errorsDetail", ignore = true)
    })
    GeneralException toGeneralException(MethodArgumentNotValidException argumentException);

}
