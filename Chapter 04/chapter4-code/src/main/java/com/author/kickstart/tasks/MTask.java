package com.author.kickstart.tasks;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class MTask {
	private static final Logger log = LoggerFactory.getLogger(MTask.class);

	@Scheduled(fixedDelay = 1 * 60 * 1000)
	public void doSomethingPeriodically() {
		log.info("Task Executed at:" + new Date());
	}

}