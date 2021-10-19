package com.bpb.publications;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RandomNumberApplication {
	private static final Logger logger = LoggerFactory.getLogger(RandomNumberApplication.class);

	public static void main(String[] args) {
		logger.error("Error log from {} for logging level {}", RandomNumberApplication.class.getSimpleName(), "ERROR");
		SpringApplication.run(RandomNumberApplication.class, args);
	}

}
