package com.author.kickstart.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.author")
@ConfigurationProperties(prefix = "harddisk.config")
public class HarddiskConfig {

	@Bean
	public Map<String, String> map() {
		Map<String, String> map = new HashMap<>();
		map.put("partitionSize", "500MB");
		return map;
	}

	private String size;
	private String brand;
	private double price;

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
