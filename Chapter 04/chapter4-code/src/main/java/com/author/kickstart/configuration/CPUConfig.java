package com.author.kickstart.configuration;

import java.util.Map;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CPUConfig {
	CPUConfig(Map<String, String> map) {
		System.out.println(map.keySet().iterator().next()); // gives output as partitionSize
	}
}
