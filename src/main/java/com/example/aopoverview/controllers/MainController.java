package com.example.aopoverview.controllers;

import org.springframework.stereotype.Component;

@Component
public class MainController {

    public String getStudentDetail(Integer studentId) {
        // do some processing
        System.out.println("Actual class: returning student details");
        return "studentDetail";
    }

    public void getStudentError() {
        System.out.println("Actual class: Error returning student details");
        Integer res = 50/0;
    }

}
