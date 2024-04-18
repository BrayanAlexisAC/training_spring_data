package com.training.pizza.exceptions.object;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GeneralException {

    private int status;

    private LocalDateTime timeStamp;

    private String error;

    private String message;

    private List<String> errorsDetail;

}
