package com.gd.model;

public class Processor {

	private String modelName;
	private String cacheMemory;
	private double price;

	public Processor(String modelName, String cacheMemory, double price) {
		super();
		this.modelName = modelName;
		this.cacheMemory = cacheMemory;
		this.price = price;
	}

	public Processor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getCacheMemory() {
		return cacheMemory;
	}

	public void setCacheMemory(String cacheMemory) {
		this.cacheMemory = cacheMemory;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Processor Model Name: " + this.modelName + "\nCache Memory: " + this.cacheMemory + "\nPrice: "
				+ this.price;
	}

}
