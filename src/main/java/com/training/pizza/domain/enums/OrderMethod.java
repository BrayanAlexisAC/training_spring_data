package com.training.pizza.domain.enums;


import java.util.Arrays;
import java.util.List;

public enum OrderMethod {
    DELIVERY("D"),
    CARRYOUT("C"),
    ON_SITE("S");

    final String value;

    OrderMethod(String value) {
        this.value = value;
    }

    public static String getValue(OrderMethod method){
        return switch (method) {
            case DELIVERY -> DELIVERY.value;
            case CARRYOUT -> CARRYOUT.value;
            case ON_SITE -> ON_SITE.value;
        };
    }

    public static List<OrderMethod> getAllMethods (){
        return Arrays.asList(
                DELIVERY,
                CARRYOUT,
                ON_SITE
        );
    }
}
