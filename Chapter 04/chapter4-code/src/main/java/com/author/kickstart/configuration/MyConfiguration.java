package com.author.kickstart.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
	@Value("${complex.values}")
	private String[] complexValues;

	public String[] getComplexValues() {
		return complexValues;
	}

}
