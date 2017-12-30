package com.boot.edu.healthcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HealthcareApplication {

	@GetMapping("/")
	public String home(){
		return "Hello world. This is a health application";
	}

	public static void main(String[] args) {
		SpringApplication.run(HealthcareApplication.class, args);
	}
}
