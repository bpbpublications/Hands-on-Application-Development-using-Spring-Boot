package com.author.kickstart.service;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	@Value("${server.port}")
	private int serverPort;

	@Value("${complex.values}")
	private int[] complexValues;

	@PostConstruct
	public void postConstruct() {
		System.out.println(serverPort);
		System.out.println(Arrays.toString(complexValues));
	}
}
