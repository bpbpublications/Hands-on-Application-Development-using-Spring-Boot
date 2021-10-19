package com.author.kickstart.configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdDatabaseConfig {
	public ProdDatabaseConfig() {
		System.out.println("prod");
	}
}
