package fr.diginamic.springmvc.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionAspect {
    private final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

    @Pointcut("execution(* fr.diginamic.springmvc.service.*.save(..))")
    @AfterThrowing(throwing = "exception")
    public void logControllerMethod(Exception exception) {
        logger.error(exception.getMessage());
        System.out.println("testexception");
    }

    
}
