package com.skf.labs.xssstored;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class XssStoredApplication {

	public static void main(String[] args) {
		SpringApplication.run(XssStoredApplication.class, args);
	}

}
