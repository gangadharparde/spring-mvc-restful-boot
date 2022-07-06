package com.gd.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gd.config.AppConfig;
import com.gd.model.Laptop;
import com.gd.model.Processor;

public class MainClasss {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext  appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		//appContext.register(AppConfig1.class);
		//appContext.register(AppConfig2.class);
		//appContext.register(AppConfig3.class);
		//appContext.refresh();

		Laptop lenovoLaptop, secondLaptop;
		Processor intelProcessor;

		System.out.println("/////////////////////////////////");
		intelProcessor= (Processor) appContext.getBean("i7");
		System.out.println(intelProcessor);
		
		System.out.println("/////////////////////////////////");
		lenovoLaptop = (Laptop) appContext.getBean("myLaptop");
		System.out.println(lenovoLaptop);
		
		System.out.println("/////////////////////////////////");
		secondLaptop = (Laptop) appContext.getBean("yourLaptop");
		System.out.println(secondLaptop);
		 
				
		appContext.close();
		
	}

}
