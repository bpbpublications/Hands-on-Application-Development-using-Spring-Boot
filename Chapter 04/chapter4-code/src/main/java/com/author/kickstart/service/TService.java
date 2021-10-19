package com.author.kickstart.service;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class TService implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(TService.class);
	@Autowired
	AsyncService asyncService;

	@Override
	public void run(String... args) throws Exception {
		Future<String> future = asyncService.doSomethingAsync();
		log.info(future.get());
	}

}
