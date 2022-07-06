
package com.gd.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myLaptop")
public class Laptop {

	private String modelName;
	private  double price;
	
	@Autowired
	@Qualifier("com.gd.model.Intel#0")
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

	@Override
	public String toString() {
		return "Laptop Model: "+ this.modelName+"\nPrice: "+this.price+"\n--------------------------\n"+processor.toString();
	}
	
}
