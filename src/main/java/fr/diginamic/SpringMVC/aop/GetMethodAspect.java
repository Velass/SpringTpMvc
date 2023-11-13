package fr.diginamic.springmvc.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GetMethodAspect {

    @After("execution(* fr.diginamic.springmvc..get*(..))")
    public void logService(JoinPoint joinPoint) {
        System.out.println("testeeeeee");
    }

    
}
