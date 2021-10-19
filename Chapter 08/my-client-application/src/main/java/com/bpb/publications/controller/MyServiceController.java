package com.bpb.publications.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bpb.publications.service.MyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MyServiceController {
	@Autowired
	RestTemplate restTemplate;

	/*@RequestMapping("/loadbalancedAPI")
	public Integer loadbalancedAPI() {
		ResponseEntity<Integer> response = restTemplate.getForEntity("http://random-number-project/generate",
				int.class);
		log.info("Responding Server Origin: " + response.getHeaders().getOrigin());
		return response.getBody();
	}*/

	@Autowired
	MyService myService;

	@RequestMapping("/loadbalancedAPI")
	public Integer loadbalancedAPI() {
		try {
			Integer response = myService.callRandomNumberService();
			return response;
		} catch (Exception e) {
			log.error("Exception raised {}:", e);
		}
		return null;
	}
}