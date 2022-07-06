Dispatcher servlet file name Rule:
<servlet-name>spring</servlet-name>
<servlet-name>-servlet.xml


As displayed in the figure, all the incoming request is intercepted by the DispatcherServlet that works as the front controller. The DispatcherServlet gets entry of handler mapping from the xml file and forwards the request to the controller. The controller returns an object of ModelAndView. The DispatcherServlet checks the entry of view resolver in the xml file and invokes the specified view component.


Following is the sequence of events corresponding to an incoming HTTP request to DispatcherServlet −
1. After receiving an HTTP request, DispatcherServlet consults the HandlerMapping to call the appropriate Controller.
2. The Controller takes the request and calls the appropriate service methods based on used GET or POST method. 3. The service method will set model data based on defined business logic and returns view name to the DispatcherServlet.
4. The DispatcherServlet will take help from ViewResolver to pickup the defined view for the request.
5. Once view is finalized, The DispatcherServlet passes the model data to the view which is finally rendered on the browser.


Commands

Ensure Tomcat server is up and in running state then run below commands-
mvn clean install tomcat7:deploy
mvn clean install tomcat7:undeploy