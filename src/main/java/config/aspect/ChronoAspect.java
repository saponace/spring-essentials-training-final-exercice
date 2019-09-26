
package config.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;

/**
 * using : System.currentTimeMillis()
 */
@Aspect
public class ChronoAspect implements Ordered {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* business.drh..*.*(..))")
    public Object chronoAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object res;
        try {
            res = joinPoint.proceed();
        } finally {
            long end = System.currentTimeMillis();
            String total = String.valueOf(end - start);
            logger.info("TTT Temps exec : '{}' de '{}' ms", joinPoint.getSignature().getName(), total);
        }
        return res;
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
