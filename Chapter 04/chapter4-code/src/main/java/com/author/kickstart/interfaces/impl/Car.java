package com.author.kickstart.interfaces.impl;

import org.springframework.context.annotation.Configuration;

import com.author.kickstart.interfaces.Vehicle;

@Configuration
public class Car implements Vehicle {

	@Override
	public int getWheels() {
		return 4;
	}

}
