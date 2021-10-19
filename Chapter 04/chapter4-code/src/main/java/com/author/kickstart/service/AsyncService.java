package com.author.kickstart.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
	private static final Logger log = LoggerFactory.getLogger(AsyncService.class);

	@Async
	public Future<String> doSomethingAsync() {
		log.info("Async Method called");
		return CompletableFuture.completedFuture("Completed");
	}
}
