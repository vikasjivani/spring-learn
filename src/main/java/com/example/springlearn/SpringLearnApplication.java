package com.example.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringLearnApplication extends SpringBootServletInitializer{
	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/spring-learn");
		SpringApplication.run(SpringLearnApplication.class, args);
	}

}
