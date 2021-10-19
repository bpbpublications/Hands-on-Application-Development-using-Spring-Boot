package com.bpb.publications.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomNumberController {

	private static final Logger log = LoggerFactory.getLogger(RandomNumberController.class);

	@GetMapping("/generate")
	public int generateFrom1to100(@Value("${server.port}") Integer port, HttpServletResponse response)
			throws UnknownHostException {
		response.addHeader("origin", InetAddress.getLocalHost().getHostAddress() + ":" + port);
		int a = new Random().ints(1, 100).limit(1).findFirst().getAsInt();
		if (a > 50) {
			log.error("Throwing exception as number is greater than 50");// any business exception for testing
			throw new NumberFormatException("number between 50 and 100");
		}
		log.info("Returning response as {}", a);
		return a;
	}
}