package com.bpb.publications.configuration;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@LoadBalancerClient(name = "random-number-project", configuration = RandomNumberConfiguration.class)
public class RestTemplateConfig {

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplateBuilder()
				.setConnectTimeout(Duration.ofMinutes(2))
				.setReadTimeout(Duration.ofMinutes(2))
				.build();
	}

}
