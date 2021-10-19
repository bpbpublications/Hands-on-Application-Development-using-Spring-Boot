package com.bpb.publications.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import com.bpb.publications.authors.service.CustomUserDetailsService;

@SpringBootApplication
@EnableDiscoveryClient
public class WebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceApplication.class, args);
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, CustomUserDetailsService service) throws Exception {
		builder.userDetailsService(service);
	}
}
