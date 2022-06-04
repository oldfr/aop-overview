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
        System.out.println("Before advice: before MainController.getStudentDetail() : " + joinPoint.getSignature().getName());
    }
    @After("execution(* com.example.aopoverview.controllers.MainController.getStudentDetail(..)) and args(studentId)")      //point-cut expression
    public void logAfter(JoinPoint joinPoint, Integer studentId)
    {
        System.out.println("After advice: After MainController.getStudentDetail() : " + joinPoint.getSignature().getName());
    }

    @Around("execution(* com.example.aopoverview.controllers.MainController.getStudentDetail(..)) and args(studentId)")      //point-cut expression
    public void logAround(ProceedingJoinPoint joinPoint, Integer studentId) throws Throwable {
//        System.out.println("Aspect class: Around MainController.getStudentDetail() : " + joinPoint.getSignature().getName());
        System.out.println("around advice: Write code for before around advise");

        joinPoint.proceed(); //continue to call method (MainController.getStudentDetail)

        System.out.println("around advice: Write code for after around advise");
    }

    @AfterReturning("execution(* com.example.aopoverview.controllers.MainController.getStudentDetail(..)) and args(studentId)")      //point-cut expression
    public void logAfterReturning(JoinPoint joinPoint, Integer studentId)
    {
        System.out.println("afterReturning advice: AfterReturning MainController.getStudentDetail() : " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "execution(* com.example.aopoverview.controllers.MainController.getStudentError(..))", throwing = "ex")      //point-cut expression
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex)
    {
            System.out.println("afterThrowing advice: AfterThrowing MainController.getStudentError() : " + joinPoint.getSignature().getName());
            System.out.println("Exception is:" + ex.getMessage());
    }
}
