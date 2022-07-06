package com.gd;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MailService implements DisposableBean {

	private Map<String, String> map = null;

	public MailService() {
		map = new HashMap<>();
	}

	public void send(String mailTo) {
		// Send mail code
		System.out.println("Inside send email method - " + mailTo);
	}

	@PostConstruct
	public void init() {
		map.put("host", "mail.gd.com");
		map.put("port", "25");
		map.put("from", "example@gd.com");
		System.out.println("Inside init method - " + map);
	}

	@Override
	public void destroy() throws Exception {
		map.clear();
		System.out.println("Inside destroy method - " + map);
	}
}
