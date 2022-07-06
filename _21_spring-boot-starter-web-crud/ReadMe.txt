For running the code in  multiple regions you can use different application.properties files

application-prod.properties
application-test.properties
application.properties


Make sure to do maven update if you dont do the code might will
use default application.properties file and then change the VM arguments as given bechrlow-
Steps
1. Alt+F5 update maven project
2. Right Click on Project Name
3. Choose Run As.. Select Run Configuration
4. Select (x)=Arguments tab
5. Provide below given VM arguments as per region (Case does not matter of test or prod)
	-Dspring.profiles.active=test  (old versions)
	-Dspring.profiles.active=prod  (old versions)
	-Dspring-boot.run.profiles=test
	-Dspring-boot.run.profiles=prod
6. Click Apply and run the file 
7. You will find port on which tomcat has started

2017-09-08 18:25:56.734  INFO 1148 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 9090 (http)
2017-09-08 18:25:56.735 DEBUG 1148 --- [           main] o.s.w.c.s.StandardServletEnvironment     : Adding [server.ports] PropertySource with highest search precedence
2017-09-08 18:25:56.740  INFO 1148 --- [           main] com.boot.App                             : Started App in 5.812 seconds (JVM running for 6.414)
