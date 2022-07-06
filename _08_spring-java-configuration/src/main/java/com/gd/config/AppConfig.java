package com.gd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Scope;

import com.gd.model.Intel;
import com.gd.model.Laptop;

@Configuration
public class AppConfig {
/*	@Configuration  //== applicationContext.xml
	class AppConfig
			@Bean   //== <bean>
			public Amd amd(){  // id=amd class="com.gd.model.Amd"
			Amd a= new Amd();
			a.setPrice();     // <proeprty name="price" value="23232"/>
			....
			....
			return a;

			}
*/
	
	@Bean(name = "i7")
	@Description("This bean is used to injection dependency inside Laptop class")
	public Intel getIntelProcessor() {
		return new Intel("Intel i7", "64MB", 6700.0, "7 Cores");
	}

	@Bean
	@Description("My Lenovo Laptop Bean")
	public Laptop myLaptop() {
		// This is JavConfig Alternative for Setter Based Injection
		Laptop myLappy = new Laptop();
		myLappy.setModelName("Lenovo Think PagEdge");
		
		// In applciationContext.xml this value will be in double quotes unlike
		// java developers who want it wihtout doubel quotes
		myLappy.setPrice(78900.00);
		myLappy.setProcessor(getIntelProcessor());
		return myLappy;
	}

	@Bean
	@Description("Your Mac Book Pro Laptop Bean")
	@Scope("singleton")
	public Laptop yourLaptop() {
		// This is JavConfig Alternative for Constructor Based Injection
		Laptop yourLappy = new Laptop("Mac Book Pro",149000.0, getIntelProcessor());
		return yourLappy;
	}
}
