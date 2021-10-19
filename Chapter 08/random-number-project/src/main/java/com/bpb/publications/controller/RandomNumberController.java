package com.bpb.publications.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomNumberController {

	@GetMapping("/generate")
	public int generateFrom1to100(@Value("${server.port}") Integer port, HttpServletResponse response)
			throws UnknownHostException {
		response.addHeader("origin", InetAddress.getLocalHost().getHostAddress() + ":" + port);
		return new Random().ints(1, 100).limit(1).findFirst().getAsInt();
	}
}