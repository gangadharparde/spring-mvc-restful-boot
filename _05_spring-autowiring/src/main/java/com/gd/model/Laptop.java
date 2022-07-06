package com.gd.model;

public class Laptop {

	private String modelName;
	private  double price;
	private Processor processor;
	
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Laptop(Processor processor) {
		super();
		this.processor = processor;
	}


	public Laptop(String modelName, double price, Processor processor) {
		super();
		this.modelName = modelName;
		this.price = price;
		this.processor = processor;
	}

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
		return "Laptop Model: "+ this.modelName+"\nPrice: "+this.price+"\n--------------------------\n"+processor.toString();
	}
	
}
