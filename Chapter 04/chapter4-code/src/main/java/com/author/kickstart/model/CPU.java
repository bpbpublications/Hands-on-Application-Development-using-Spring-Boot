package com.author.kickstart.model;

public class CPU {

	private String processor;
	private int generation;

	public CPU(String processor, int generation) {
		this.processor = processor;
		this.generation = generation;
	}

	public CPU() {
		// TODO Auto-generated constructor stub
	}

	public String getInfo() {
		return "info";
	}  

}