package com.skf.labs.authbypass1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AuthBypass1Application {

	public static void main(String[] args) {
		SpringApplication.run(AuthBypass1Application.class, args);
	}

}
