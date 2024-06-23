package com.jims.jims_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JimsProjectApplication {

	public static void main(String[] args) {
		
			//LAUNCH APP
			new CLIInterface().userChoiseMenu();

		SpringApplication.run(JimsProjectApplication.class, args);
	}

}
