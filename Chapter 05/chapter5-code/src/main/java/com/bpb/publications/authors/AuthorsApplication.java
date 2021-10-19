package com.bpb.publications.authors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AuthorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorsApplication.class, args);
	}

}
