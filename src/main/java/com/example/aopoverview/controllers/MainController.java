package com.example.aopoverview.controllers;

import org.springframework.stereotype.Component;

@Component
public class MainController {

    //method to check all aspects except AfterThrowing
    public String getStudentDetail(Integer studentId) {
        // do some processing
        System.out.println("-Actual class: returning student details");
        return "studentDetail";
    }

    //method to check aspect - AfterThrowing
    public void getStudentError() {
        System.out.println("-Actual class: Error returning student details");
        Integer res = 50/0;
    }

}
