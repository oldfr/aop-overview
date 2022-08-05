package com.example.aopoverview.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component // will not work without @Component
public class StudentCRUDAspect {

    @Before("execution(* com.example.aopoverview.controllers.MainController.getStudentDetail(..)) and args(studentId)")     //point-cut expression
    public void logBefore(JoinPoint joinPoint, Integer studentId)
    {
        System.out.println("-Before advice: MainController-> " + joinPoint.getSignature().getName());
    }
    @After("execution(* com.example.aopoverview.controllers.MainController.getStudentDetail(..)) and args(studentId)")      //point-cut expression
    public void logAfter(JoinPoint joinPoint, Integer studentId)
    {
        System.out.println("-After advice: MainController-> " + joinPoint.getSignature().getName());
    }

    @Around("execution(* com.example.aopoverview.controllers.MainController.getStudentDetail(..)) and args(studentId)")      //point-cut expression
    public void logAround(ProceedingJoinPoint joinPoint, Integer studentId) throws Throwable {
//        System.out.println("Aspect class: Around MainController.getStudentDetail() : " + joinPoint.getSignature().getName());
        System.out.println("-Around advice: before");

        joinPoint.proceed(); //continue to call method (MainController.getStudentDetail)

        System.out.println("-Around advice: after");
    }

    @AfterReturning("execution(* com.example.aopoverview.controllers.MainController.getStudentDetail(..)) and args(studentId)")      //point-cut expression
    public void logAfterReturning(JoinPoint joinPoint, Integer studentId)
    {
        System.out.println("-AfterReturning advice: MainController-> " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "execution(* com.example.aopoverview.controllers.MainController.getStudentError(..))", throwing = "ex")      //point-cut expression
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex)
    {
            System.out.println("-AfterThrowing advice: -> " + joinPoint.getSignature().getName());
            System.out.println("Exception is:" + ex.getMessage());
    }
}
