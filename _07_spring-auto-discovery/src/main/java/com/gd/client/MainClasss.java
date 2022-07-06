package com.gd.client;

import java.util.Map;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gd.model.Laptop;

public class MainClasss {

	private static ListableBeanFactory listableBeanFactory;
	public static void main(String[] args) {

		Laptop lenovoLaptop;

		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		lenovoLaptop = (Laptop) appContext.getBean("myLaptop");
		System.out.println(lenovoLaptop);
		
		getAllBeans(appContext);
		((ClassPathXmlApplicationContext) appContext).close();
			
	}
	private static void getAllBeans(ApplicationContext appContext) {
		listableBeanFactory = (ListableBeanFactory) appContext;
		System.out.println("######################################## Your Container Objects ########################################");
		
		Map<String, Object> map = listableBeanFactory.getBeansOfType(Object.class);
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "  ---------------->  " + entry.getValue());
		}
	}

}
