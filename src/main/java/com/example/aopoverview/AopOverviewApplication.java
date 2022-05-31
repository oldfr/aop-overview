package com.example.aopoverview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.aopoverview.controllers.MainController;

@SpringBootApplication
public class AopOverviewApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(AopOverviewApplication.class, args);
		MainController controller = context.getBean(MainController.class);
		controller.testing();
	}

}
