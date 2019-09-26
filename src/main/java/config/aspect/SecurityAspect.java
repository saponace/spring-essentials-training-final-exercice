
package config.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.procedure.ParameterMisuseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import web.drh.controller.exception.InsufficientAuthorizationException;
import web.drh.controller.exception.NotLoggedInException;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

@Aspect
public class SecurityAspect implements Ordered {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String ADMIN_USERNAME = "admin";

    @Around("execution(@web.drh.controller.annotation.Secured public * *(.., javax.servlet.http.HttpServletRequest, ..))")
    public Object securityCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        final Optional<Object> optionalRequest = Arrays.asList(joinPoint.getArgs())
                .stream()
                .filter(o -> o instanceof HttpServletRequest)
                .findFirst();
        if (optionalRequest.isPresent()) {
            final HttpServletRequest request = (HttpServletRequest) optionalRequest.get();
            final String username = request.getHeader("username");
            if (username == null) {
                throw new NotLoggedInException("User not logged in");
            } else if (!ADMIN_USERNAME.equals(username)) {
                throw new InsufficientAuthorizationException(
                        "User \"" + username + "\" not authorized to access this resource");
            } else {
                return joinPoint.proceed();
            }
        } else {
            throw new ParameterMisuseException("Controller method requires a HttpServletRequest parameter");
        }
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
