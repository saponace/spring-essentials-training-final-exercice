package web.drh.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MyRestException extends RuntimeException {
    public MyRestException() {
    }

    public MyRestException(String message) {
        super(message);
    }

    public MyRestException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyRestException(Throwable cause) {
        super(cause);
    }

    public MyRestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
