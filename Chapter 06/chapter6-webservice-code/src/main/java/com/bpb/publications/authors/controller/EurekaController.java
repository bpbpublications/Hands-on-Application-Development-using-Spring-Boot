package com.bpb.publications.authors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaController {
	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping(name = "Get Eureka Service Instances", value = "/service-instances", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getEurekaServices() {
		System.out.println(discoveryClient.getInstances("web-service"));
		return new ResponseEntity<>(this.discoveryClient.getServices(), HttpStatus.OK);
	}

}
