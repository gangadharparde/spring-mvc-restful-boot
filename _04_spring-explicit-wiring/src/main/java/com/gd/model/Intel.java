package com.gd.model;

public class Intel extends Processor {
	private String numberOfCores;

	public Intel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Intel(String modelName, String cacheMemory, double price) {
		super(modelName, cacheMemory, price);
		// TODO Auto-generated constructor stub
	}

	public Intel(String modelName, String cacheMemory, double price, String numberOfCores) {
		super(modelName, cacheMemory, price);
		this.numberOfCores = numberOfCores;
	}

	public String getNumberOfCores() {
		return numberOfCores;
	}

	public void setNumberOfCores(String numberOfCores) {
		this.numberOfCores = numberOfCores;
	}

	@Override
	public String toString() {
		/*
		 * return "Processor Model Name: " + this.getModelName() +
		 * "\nCache Memory: " + this.getCacheMemory() + "\n Price: " +
		 * this.getPrice() + "Number of Cores: " + this.numberOfCores;
		 */
		return (super.toString() + "\nNumber of Cores: " + this.numberOfCores);

	}

}
