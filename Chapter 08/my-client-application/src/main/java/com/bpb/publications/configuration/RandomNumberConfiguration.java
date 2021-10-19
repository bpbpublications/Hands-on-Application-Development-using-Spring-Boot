
package com.bpb.publications.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Flux;

@Configuration
public class RandomNumberConfiguration {

	@Bean
	ServiceInstanceListSupplier serviceInstanceListSupplier() {
		return new SimpleServiceInstanceListSupplier("random-number-project");
	}
}

class SimpleServiceInstanceListSupplier implements ServiceInstanceListSupplier {

	private final String serviceId;

	SimpleServiceInstanceListSupplier(String serviceId) {
		this.serviceId = serviceId;
	}

	@Override
	public String getServiceId() {
		return serviceId;
	}

	@Override
	public Flux<List<ServiceInstance>> get() {
		return Flux.just(Arrays.asList(new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 7001, false),
				new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 7002, false),
				new DefaultServiceInstance(serviceId + "3", serviceId, "localhost", 7003, false)));
	}
}