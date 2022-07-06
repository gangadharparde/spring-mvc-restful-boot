package com.gd.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Laptop {

	private String modelName;
	private double price;

	@Autowired
	private Processor processor;

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Processor getProcessor() {
		return processor;
	}

	public void setProcessor(Processor processor) {
		this.processor = processor;
	}

	@Override
	public String toString() {
		return "Laptop Model: " + this.modelName + "\nPrice: " + this.price + "\n--------------------------\n"
				+ processor.toString();
	}

}
