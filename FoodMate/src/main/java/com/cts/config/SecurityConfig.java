package com.cts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.cts.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
    PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//using this bean we are able to create the user
	@Bean
	UserDetailsService userDetailsService() {
		return new UserService();
	}
	
	//this bean is for configuring security i.e. http security
	@Bean
	 SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(
				(requests) -> requests.requestMatchers("/auth/**","/address-rest/**").permitAll())
//				.anyRequest().authenticated())
//				.authenticationProvider(authenticationProvider())
						.csrf(csrf -> csrf.disable());
				return http.build();
	}
	
	
	

}
