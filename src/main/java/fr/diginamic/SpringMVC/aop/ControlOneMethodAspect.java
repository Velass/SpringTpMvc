package fr.diginamic.springmvc.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControlOneMethodAspect {
    private final Logger logger = LoggerFactory.getLogger(ControlOneMethodAspect.class);

    @After("execution(* fr.diginamic.springmvc.restController..*(..))")
    public void logControllerMethod(JoinPoint joinPoint) {
        logger.info("contoller method {}", joinPoint.getSignature().getName());
        String methodName = new Object() {}
      .getClass()
      .getEnclosingMethod()
      .getName();
        System.out.println("test");
        System.out.println(methodName);
    }

    
}
