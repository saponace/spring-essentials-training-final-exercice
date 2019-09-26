package web.drh.controller.handlerexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import web.drh.controller.exception.InsufficientAuthorizationException;
import web.drh.controller.exception.MyRestNoStatusException;
import web.drh.controller.exception.OwnBean;

@ControllerAdvice(annotations = RestController.class)
public class InsufficientAuthorizationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
        InsufficientAuthorizationException.class
    })
    protected ResponseEntity<?> handleMyRestException(MyRestNoStatusException ex) {

        OwnBean ownBean = new OwnBean(ex.getMessage(), "");
        return new ResponseEntity<>(
            ownBean,
            HttpStatus.FORBIDDEN);
    }
}
