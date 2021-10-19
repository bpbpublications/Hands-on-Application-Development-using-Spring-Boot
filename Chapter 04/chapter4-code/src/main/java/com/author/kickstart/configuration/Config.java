package com.author.kickstart.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.author.kickstart.model.CPU;

@Configuration
@Lazy
public class Config {
	/*@Bean("cpu")
	public CPU createCpu() {
		return new CPU("i5", 7);
	}*/
	@Bean
	public CPU cpu() {
		System.out.println("CPU is initializing");
		return new CPU();
	}  

}
