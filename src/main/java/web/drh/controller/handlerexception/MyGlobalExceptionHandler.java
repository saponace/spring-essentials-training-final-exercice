package web.drh.controller.handlerexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import web.drh.controller.exception.MyRestNoStatusException;
import web.drh.controller.exception.OwnBean;

import javax.servlet.http.HttpServletRequest;

// @ControllerAdvice(annotations = ApplyMyGlobalExceptionHandler.class)

@ControllerAdvice(annotations = RestController.class)
public class MyGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public MyGlobalExceptionHandler() {
        this.logger.info(" Creating MyRestExceptionHandler");
    }

    // version 1, with no data
    // @ExceptionHandler({
    //     MyRestNoStatusException.class,
    // })
    // protected ResponseEntity<Object> handleMyRestException(
    //     MyRestNoStatusException ex, HttpHeaders headers,
    //     HttpStatus status, WebRequest request) {
    //
    //     return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    // }

    /**
     * version2 with data OwnBean
     */
    @ExceptionHandler({
        MyRestNoStatusException.class,
    })
    protected ResponseEntity<?> handleMyRestException(MyRestNoStatusException ex) {

        OwnBean ownBean = new OwnBean(ex.getMessage(), "522kkkk");
        return new ResponseEntity<OwnBean>(
            ownBean,
            HttpStatus.BAD_GATEWAY);
    }

    /**
     *
     */
    @ExceptionHandler({
        MethodArgumentTypeMismatchException.class,
    })
    protected ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex,
                                                                          HttpServletRequest request) {

        ErrorDetailBean errorDetailBean = ErrorDetailBean.build(ex, request, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorDetailBean, errorDetailBean.getHttpStatus());
    }

    /**
     * For ANY other Exception not managed above (order important in this class)
     * => then this handler will be executed
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllException(Exception ex, HttpServletRequest request) {
        ErrorDetailBean errorDetailBean = ErrorDetailBean.build(ex, request, HttpStatus.INTERNAL_SERVER_ERROR);
        HttpHeaders headers = new HttpHeaders();
        logger.error("", ex);
        return new ResponseEntity<>(errorDetailBean, headers, errorDetailBean.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
        MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        /**
         * As seen here the WebRequest is a PB because it does NOT contains the useful URI.
         * That is why I prefer to recode completely the MyGlobalExceptionHandler.
         * or cast into ServletWebRequest ...
         */
        ServletWebRequest ser = (ServletWebRequest) request;
        ErrorDetailBean errorDetailBean = ErrorDetailBean.build(ex, ((ServletWebRequest) request).getRequest(), HttpStatus.BAD_REQUEST);
        logger.error("", ex);
        // logger.info("request.getContextPath()" + request.getContextPath());
        // logger.info("request.getContextPath()" + request.toString());
        return new ResponseEntity<>(errorDetailBean, headers, errorDetailBean.getHttpStatus());
    }

}
