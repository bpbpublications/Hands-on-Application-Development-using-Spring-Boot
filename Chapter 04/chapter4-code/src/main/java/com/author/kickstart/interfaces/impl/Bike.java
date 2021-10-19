package com.author.kickstart.interfaces.impl;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.author.kickstart.interfaces.Vehicle;

@Configuration
@Primary
public class Bike implements Vehicle {

	@Override
	public int getWheels() {
		return 2;
	}

}