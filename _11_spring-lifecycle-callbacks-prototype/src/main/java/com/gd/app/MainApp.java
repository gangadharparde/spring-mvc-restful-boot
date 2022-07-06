package com.gd.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gd.AppConfig;
import com.gd.MailService;

//In contrast to the other scopes, Spring does not manage the complete lifecycle of a prototype bean**: the container instantiates, configures, and otherwise assembles a prototype object, and hands it to the client, with no further record of that prototype instance.
//Thus, although initialization lifecycle callback methods are called on all objects regardless of scope, in the case of prototypes, configured destruction lifecycle callbacks are not called. The client code must clean up prototype-scoped objects and release expensive resources that the prototype bean(s) are holding.
//
//To get the Spring container to release resources held by prototype-scoped beans, try using a custom bean post-processor, which holds a reference to beans that need to be cleaned up.

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
      
      // Send mail 1
      MailService mailService1 = context.getBean(MailService.class);
      mailService1.send("coupancodes@gd.com");

      // Send mail 2
      MailService mailService2 = context.getBean(MailService.class);
      mailService2.send("newletters@gd.com");

      context.close();
   }
}
