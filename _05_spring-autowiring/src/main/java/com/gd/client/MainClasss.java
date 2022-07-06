package com.gd.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gd.model.Laptop;

public class MainClasss {

	public static void main(String[] args) {

		Laptop lenovoLaptop, secondLaptop, thirdLaptop;

		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		lenovoLaptop = (Laptop) appContext.getBean("myLaptop");
		System.out.println(lenovoLaptop);
		
		System.out.println("//////////////////////////////////////");
		secondLaptop = (Laptop) appContext.getBean("yourLaptop");
		System.out.println(secondLaptop);
		 
		
		System.out.println("//////////////////////////////////////");
		thirdLaptop= (Laptop) appContext.getBean("wowLaptop");
		System.out.println(thirdLaptop);
		 
		
		((ClassPathXmlApplicationContext) appContext).close();
	}

}
