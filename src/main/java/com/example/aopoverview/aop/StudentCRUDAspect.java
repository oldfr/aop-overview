package com.example.aopoverview.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component // will not work without @Component
public class StudentCRUDAspect {

    @Before("execution(* com.example.aopoverview.controllers.MainController.testing(..))")     //point-cut expression
    public void logBefore(JoinPoint joinPoint)
    {
        System.out.println("before MainController.testing() : " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.aopoverview.controllers.MainController.testing(..))")     //point-cut expression
    public void logAfter(JoinPoint joinPoint)
    {
        System.out.println("After MainController.testing() : " + joinPoint.getSignature().getName());
    }

    @Around("execution(* com.example.aopoverview.controllers.MainController.testing(..))")     //point-cut expression
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around MainController.testing() : " + joinPoint.getSignature().getName());
        System.out.println("Write code for before advise");

        joinPoint.proceed(); //continue to called method i.e. EmployeeManager.getEmployeeById()

        System.out.println("Write code for after advise");
    }

    @AfterReturning("execution(* com.example.aopoverview.controllers.MainController.testing(..))")     //point-cut expression
    public void logAfterReturning(JoinPoint joinPoint)
    {
        System.out.println("AfterReturning MainController.testing() : " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("execution(* com.example.aopoverview.controllers.MainController.testing(..))")     //point-cut expression
    public void logAfterThrowing(JoinPoint joinPoint)
    {
        System.out.println("AfterThrowing MainController.testing() : " + joinPoint.getSignature().getName());
    }
}
