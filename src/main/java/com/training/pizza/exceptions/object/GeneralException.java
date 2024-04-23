package com.training.pizza.exceptions.object;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GeneralException {

    private int status;

    private LocalDateTime timeStamp;

    private String error;

    private String message;

    private Map<String, String> errorsDetail;

}
