package web.drh.controller.exception;

public class MyRestNoStatusException extends RuntimeException {
    public MyRestNoStatusException() {
    }

    public MyRestNoStatusException(String message) {
        super(message);
    }

    public MyRestNoStatusException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyRestNoStatusException(Throwable cause) {
        super(cause);
    }

    public MyRestNoStatusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
