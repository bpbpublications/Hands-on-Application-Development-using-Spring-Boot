
package com.bpb.publications.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MyService {

	@Autowired
	RestTemplate restTemplate;

	@Retry(name = "random-number-generator-circuit-breaker")//, fallbackMethod = "fallbackMethodForRandomNumberProject")
	//@CircuitBreaker(name = "random-number-generator-circuit-breaker", fallbackMethod = "fallbackMethodForRandomNumberProject")
	//@Bulkhead(name = "random-number-generator-circuit-breaker", fallbackMethod = "fallbackMethodForRandomNumberProject") 
	public Integer callRandomNumberService() {
		ResponseEntity<Integer> response = restTemplate.getForEntity("http://random-number-project/generate",
				int.class);
		log.info("Received response as {} from {}", response.getBody(), response.getHeaders().get("origin"));
		return response.getBody();
	}

	public Integer fallbackMethodForRandomNumberProject(Throwable e) {
		return 101;
	}

}
