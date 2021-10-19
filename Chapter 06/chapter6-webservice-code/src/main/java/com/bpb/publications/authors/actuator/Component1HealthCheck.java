package com.bpb.publications.authors.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.bpb.publications.authors.service.interfaces.AppEnvironment;

@Component
public class Component1HealthCheck implements HealthIndicator {
	@Autowired
	AppEnvironment appEnvironment;

	@Override
	public Health health() {
		// some health check on any dependency which returns true or false.
		boolean running = true;
		if (running) {
			return Health.up().withDetail("component1", "value1").withDetail("env", checkEnv()).build();
		} else {
			return Health.down().withDetail("component1", "component1 is failing due to some error")
					.withDetail("env", checkEnv()).build();
		}
	}

	public String checkEnv() {
		return appEnvironment.name();
	}
}
