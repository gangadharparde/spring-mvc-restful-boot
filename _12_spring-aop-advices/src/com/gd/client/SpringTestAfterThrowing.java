package com.gd.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gd.CustomerBo;

public class SpringTestAfterThrowing {

	public static void main(String[] args) throws Exception {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"springCustomer.xml");
		CustomerBo customer = (CustomerBo) appContext.getBean("customerBo");
		customer.addCustomerThrowException();
		((ClassPathXmlApplicationContext) appContext).close();

	}

}
