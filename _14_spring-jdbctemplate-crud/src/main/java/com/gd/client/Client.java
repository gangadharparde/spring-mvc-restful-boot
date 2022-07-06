package com.gd.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gd.dao.AccountDao;
import com.gd.model.Account;

public class Client {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_Jdbc.xml");
		AccountDao accDao = (AccountDao) context.getBean("accountDao");
		// INSERT
		System.out.println("INSERTING.......");
		accDao.save(new Account(1, "GD", "Saving", 12000.00));
		System.out.println(accDao.get(1));

		// UPDATE
		System.out.println("UPDATING.......");
		accDao.update(1, new Account(2, "GD jGeek", "Saving", 22000.00));
		System.out.println(accDao.get(2));

		// DELETE
		System.out.println("DELETING.......");
		accDao.remove(2);
		System.out.println(accDao.get(2));

		
		// LISTING ALL
		System.out.println("LISTING ALL .......");
		List<Account> allAccounts = accDao.getlist();

		for (Account account : allAccounts) {
			System.out.println(account);
		}

		((ClassPathXmlApplicationContext) context).close();
	}
}
