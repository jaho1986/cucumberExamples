package com.jaho.cucumber.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.jaho.cucumber.course"})
public class CucumberApplication {

	public static void main(String[] args) {
		SpringApplication.run(CucumberApplication.class);
	}

}
