package com.skf.labs.xssstored;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().permitAll()
            .and()
            .formLogin().disable()
            .csrf()
            .and()
            .headers(headers ->
                headers.contentSecurityPolicy(
                    cps -> cps.policyDirectives("script-src 'self'")
            ));

        return http.build();
    }
}