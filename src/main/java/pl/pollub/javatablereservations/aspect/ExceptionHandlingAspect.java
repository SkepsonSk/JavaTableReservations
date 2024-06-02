package pl.pollub.javatablereservations.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlingAspect.class);

    @AfterThrowing(pointcut = "execution(* pl.pollub.javatablereservations..*(..))", throwing = "ex")
    public void logException(Exception ex) {
        LOGGER.error("Exception thrown in method: " + ex.getMessage());
    }
}
