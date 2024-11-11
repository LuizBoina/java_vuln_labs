package com.skf.labs.csrf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class CsrfApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsrfApplication.class, args);
	}

}
