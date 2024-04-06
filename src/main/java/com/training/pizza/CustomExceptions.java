package com.training.pizza;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class CustomExceptions extends ResponseStatusException {


    public CustomExceptions(HttpStatusCode status) {
        super(status);
    }

    public CustomExceptions(HttpStatusCode status, String reason) {
        super(status, reason);
    }

    public CustomExceptions(int rawStatusCode, String reason, Throwable cause) {
        super(rawStatusCode, reason, cause);
    }

    public CustomExceptions(HttpStatusCode status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

    protected CustomExceptions(HttpStatusCode status, String reason, Throwable cause, String messageDetailCode, Object[] messageDetailArguments) {
        super(status, reason, cause, messageDetailCode, messageDetailArguments);
    }
}
