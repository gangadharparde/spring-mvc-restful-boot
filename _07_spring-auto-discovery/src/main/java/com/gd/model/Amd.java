package com.gd.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Amd extends Processor {
	private boolean graphicsAcceleration;
	
	public Amd() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Amd(String modelName, String cacheMemory, double price) {
		super(modelName, cacheMemory, price);
		// TODO Auto-generated constructor stub
	}

	public Amd(String modelName, String cacheMemory, double price, boolean graphicsAcceleration) {
		super(modelName, cacheMemory, price);
		this.graphicsAcceleration = graphicsAcceleration;
	}

	public boolean isGraphicsAcceleration() {
		return graphicsAcceleration;
	}

	public void setGraphicsAcceleration(boolean graphicsAcceleration) {
		this.graphicsAcceleration = graphicsAcceleration;
	}

	@Override
	public String toString() {
		/*
		 * return "Processor Model Name: " + this.getModelName() +
		 * "\nCache Memory: " + this.getCacheMemory() + "\n Price: " +
		 * this.getPrice() + "Number of Cores: " + this.numberOfCores;
		 */
		return (super.toString() + "\nHas Graphics Acceleration?: " + this.graphicsAcceleration);

	}

	
	
}
