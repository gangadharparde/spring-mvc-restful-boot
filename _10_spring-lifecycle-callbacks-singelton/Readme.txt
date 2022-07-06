If you are using spring-boot and below dependency then it should add javax.annotation automatically from parent starter.

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
For non spring boot starter data jpa add below dependency in pom.xml

<dependency>
  <groupId>javax.annotation</groupId>
  <artifactId>javax.annotation-api</artifactId>
  <version>1.3.2</version>
</dependency>