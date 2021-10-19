package com.author.kickstart.configuration;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.author.kickstart.model.CPU;
import com.author.kickstart.tasks.MTask;

@Configuration
@EnableScheduling
public class AppConfig {

	private static final Logger log = LoggerFactory.getLogger(AppConfig.class);
	@Lazy
	@Autowired
	CPU cpu;

	@PostConstruct
	public void callAfterBeanCreation() {
		cpu.getInfo();
	}

	@Bean
	public MTask mTask() {
		return new MTask();
	}

	@Scheduled(fixedDelay = 1 * 60 * 1000)
	public void doSomethingPeriodically() {
		log.info("Task Executed at:" + new Date());
	}

}
