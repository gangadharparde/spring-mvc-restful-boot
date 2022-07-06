http://www.jcombat.com/spring/understanding-aspect-oriented-programming-aop
http://howtodoinjava.com/spring/spring-aop/writing-spring-aop-aspectj-pointcut-expressions-with-examples/

https://www.slideshare.net/javaonkar/spring-aop-onkar
https://en.wikipedia.org/wiki/Aspect-oriented_programming#AspectJ.27s_join-point_model


https://www.slideshare.net/thanhc0110m/ioc-and-aop-presentation
=====================
There are a few AOP terminologies that needs to be kept in mind.

Aspect: Aspect is the modularization of a concern that cuts across multiple objects. Logging and Transaction management are the best examples of cross-cutting concern in Java. In Spring AOP, aspects are implemented using regular classes (the schema-based approach, with XML based configuration) or regular classes annotated with the @Aspect annotation (@AspectJ style), for which AspectJ needs to be integrated with Spring.

Join Point: In Spring AOP, a Join Point always represents a method execution. This represents a point in your application where you can plug-in AOP aspect. You can also say, it is the actual place in the application where an action will be taken using Spring AOP framework.

Advice: Action taken by an Aspect at a particular join point.  Different types of advice include “around“,”before“, “after“, “after returning” and “after throwing” advice. Around advice is the most important and powerful of all, where the advice code gets executed before and after the execution of the JoinPoint methods. It is the responsibility of around advice to invoke the join point methods, and finally return the respective values if the JoinPoint method returns any.

Pointcut: Advice is associated with a pointcut expression and runs at any join point matched by the pointcut. That means, in the above example, the expression (“execution(* com.jcombat.customer.bo.CustomerBo.addCustomer(..))”)
is the pointcut and the corresponding matching set of methods, to which the LoggingAspect needs to be applied, is the Join Point. In other words, you can say that, set of Join Points is called a PointCut.

Target object: The object that is being advised by one or more aspects. Also referred to as the advised object.

Weaving: Weaving is the process of linking aspects with other objects to create an advised object. This can be done at compile time, load time, or at runtime. Spring AOP performs weaving at the runtime.

====================
1) Matching Method Signature Patterns

The most typical pointcut expressions are used to match a number of methods by their signatures.

Matching all methods within a class in another package

For example, the following pointcut expression matches all of the methods declared in the EmployeeManager interface. The preceding wildcard matches methods with any modifier (public, protected, and private) and any return type. The two dots in the argument list match any number of arguments.

execution(* com.howtodoinjava.EmployeeManager.*(..))
Matching all methods within a class within same package

You can omit the package name if the target class or interface is located in the same package as this aspect.

execution(* EmployeeManager.*(..))
Matching all public methods in EmployeeManager

Use public keyword in start, and use * to match any return type.

execution(public * EmployeeManager.*(..))
Matching all public methods in EmployeeManager with return type EmployeeDTO

Use public keyword and return type in start.

execution(public EmployeeDTO EmployeeManager.*(..))
Matching all public methods in EmployeeManager with return type EmployeeDTO and first parameter as EmployeeDTO

Use public keyword and return type in start. Also, specify your first parameter as well. Rest parameters can be matched through two dots.

execution(public EmployeeDTO EmployeeManager.*(EmployeeDTO, ..))
Matching all public methods in EmployeeManager with return type EmployeeDTO and definite parameters

Use public keyword and return type in start. Also, specify all parameter types as well.

execution(public EmployeeDTO EmployeeManager.*(EmployeeDTO, Integer))
2) Matching Type Signature Patterns

When applied to Spring AOP, the scope of these pointcuts will be narrowed to matching all method executions within the certain types only.

Matching all methods defined in classes inside package com.howtodoinjava

It’s much like previous example.

within(com.howtodoinjava.*)
Matching all methods defined in classes inside package com.howtodoinjava and classes inside all sub-packages as well

For including, sub-packages use two dots.

within(com.howtodoinjava..*)
Match all methods with a class in another package

Much like previous example using execution keyword.

within(com.howtodoinjava.EmployeeManagerImpl)
Match all methods with a class in same package

In case of same package, drop package name.

within(EmployeeManagerImpl)
Match all methods within all all implementing classes of EmployeeManager interface

Use + (plus) sign to match all implementations of an interface.

within(EmployeeManagerImpl+)
3) Matching Bean Name Patterns

You can match all beans as well having a common naming pattern e.g.

Match all methods defined in beans whose name ends with ‘Manager’.

It’s quite easy one. Use an * to match anything preceding in bean name and then matching word.

bean(*Manager)
4) Combining Pointcut Expressions

In AspectJ, pointcut expressions can be combined with the operators && (and), || (or), and ! (not). e.g.

Match all methods with names ending with Manager and DAO

Use ‘||’ sign to combine both expressions.

bean(*Manager) || bean(*DAO)
I hope that above information will help you when you face any difficulty in determining the correct pointcut expression in your application.

Happy Learning !!
============
