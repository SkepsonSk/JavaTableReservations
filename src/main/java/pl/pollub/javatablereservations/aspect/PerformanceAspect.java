package pl.pollub.javatablereservations.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

@Aspect
@Configurable
public class PerformanceAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceAspect.class);

    @Around("@annotation(measure)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint, Measure measure) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        LOGGER.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }
}
