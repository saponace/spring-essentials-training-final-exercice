package web.drh.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InsufficientAuthorizationException extends RuntimeException {
    public InsufficientAuthorizationException() {
    }

    public InsufficientAuthorizationException(String message) {
        super(message);
    }

    public InsufficientAuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficientAuthorizationException(Throwable cause) {
        super(cause);
    }

    public InsufficientAuthorizationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
