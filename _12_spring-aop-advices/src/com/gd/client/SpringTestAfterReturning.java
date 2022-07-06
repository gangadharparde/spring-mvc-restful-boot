package com.gd.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gd.CustomerBo;

public class SpringTestAfterReturning {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("springCustomer.xml");
		CustomerBo customer = (CustomerBo) appContext.getBean("customerBo");
		customer.addCustomerReturnValue();
		((ClassPathXmlApplicationContext) appContext).close();

	}

}
