package com.gd.client;

import com.gd.model.Amd;
import com.gd.model.Intel;
import com.gd.model.Laptop;
import com.gd.model.Processor;

public class Main {

	public static void main(String[] args) {
		
		//Processor iDontKnowWhich1;
		//Laptop lenovoLaptop;
	
		//Spring DI/IoC   DI==IoC
		
		//Processor myP= new Processor();
		//myLpatop.setProcessor(myP);
		
		//System.out.println(myP);
		//System.out.println(new Processor("Core i3", "6 MB", 1200.00).getPrice());
		
		
		Laptop myLpatop = new Laptop();
		
		
		//Remove this 1
		Processor iDontKnowWhich1= new Intel("Core i7", "64 MB", 6000.00,"8 Cores");
		//Remove this 2
		Laptop lenovoLaptop=new Laptop("ThinkPad Edge", 78000.00, iDontKnowWhich1);
		
		System.out.println("Year 2000");
		System.out.println(lenovoLaptop);

		//Remove this 3
		iDontKnowWhich1= new Amd("AMD Xenon", "64 MB", 6000.00,true);
		//Remove this 4
		lenovoLaptop.setProcessor(iDontKnowWhich1);
		

		System.out.println("Year 2017");
		System.out.println(lenovoLaptop);

	}

}
