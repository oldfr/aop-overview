package com.example.aopoverview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.aopoverview.controllers.MainController;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopOverviewApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(AopOverviewApplication.class, args);
		MainController controller = context.getBean(MainController.class);
		try{
		controller.getStudentDetail(20);
		controller.getStudentError();
		}
		catch (Exception e) {
			System.out.println("handled error:"+e.getMessage());
		}
	}

}
