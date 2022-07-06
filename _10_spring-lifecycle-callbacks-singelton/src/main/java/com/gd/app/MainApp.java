package com.gd.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gd.AppConfig;
import com.gd.MailService;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
      
      // Send mail 1
      MailService mailService1 = (MailService) context.getBean("mailService");
      mailService1.send("coupancodes@gd.com");

      // Send mail 2
      MailService mailService2 = context.getBean(MailService.class);
      mailService2.send("newletters@gd.com");

      context.close();
   }
}
