package com.author.kickstart.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import com.author.kickstart.interfaces.Vehicle;

@Configuration
public class VehicleService {

	@Autowired
	// @Qualifier("car")
	Vehicle vehicle;

	@PostConstruct
	public void service() {
		System.out.println("Wheels for vehicle:" + vehicle.getWheels());
	}

}