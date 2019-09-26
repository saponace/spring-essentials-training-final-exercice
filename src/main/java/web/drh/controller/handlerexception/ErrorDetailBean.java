package web.drh.controller.handlerexception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Redefining almost the SAME fields as regular Spring-boot
 * <ul>
 * <li>timestamp - The time that the errors were extracted</li>
 * <li>status - The status code</li>
 * <li>error - The error reason</li>
 * <li>exception - The class name of the root exception (if configured)</li>
 * <li>message - The exception message</li>
 * <li>path - The URL path when the exception was raised</li>
 * <p>
 * removed From Original code errors and trave because they are bothering us ..
 * <li>errors - Any ObjectError from a BindingResult exception
 * <li>trace - The exception stack trace</li>
 * </ul>
 * <p>
 * SO in the end, I propose the following REST Error Model
 * * {
 * * "timestamp": "2018-11-16T17:41:54.635+0000",
 * * "status": 500,
 * * "error": "Internal Server Error",
 * * "message": "No value present",
 * * "path": "/infos/-100"
 * * }
 */
@JsonPropertyOrder({"timestamp", "status", "error", "exception", "message", "path"})
public class ErrorDetailBean {

    private int status;
    private String message;
    private Date timestamp;
    private String path;
    private String error;
    private String exception;
    @JsonIgnore
    private HttpStatus httpStatus;

    /**
     * Use ErrorDetailBean.build(..) helper method to help you extract data from httpRequest and exception
     */
    private ErrorDetailBean() {
    }

    public static ErrorDetailBean build(Exception ex, HttpServletRequest request, HttpStatus status) {

        ErrorDetailBean errorDetail = new ErrorDetailBean();
        errorDetail.setTimestamp(new Date());
        errorDetail.setHttpStatus(status);
        errorDetail.setMessage(ex.getMessage());
        if (request != null) {
            errorDetail.setPath(request.getRequestURI());
        }
        errorDetail.setException(ex.getClass().toString());
        return errorDetail;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    //  errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
    // errorDetail.setError(HttpStatus.NOT_FOUND.getReasonPhrase());

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus status) {
        this.httpStatus = status;
        this.status = status.value();
        this.error = status.getReasonPhrase();
    }

    public String getError() {
        return error;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
