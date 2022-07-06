<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<style>
* {
	font-family: verdana;
	font-size: 9px;
}
</style>
<body style="font-family: verdana">
	<hr>
	Welcome ${fn:toUpperCase(userName)}, What you want to do today?
	<hr>
	<ul
		style='background: conic-gradient(lightpink, white, powderblue); list-style-type: none; text-align: center; margin: 0; padding: 0;'>
		<li style='display: inline-block; padding: 2px;'><a
			href="add-employee">Add Employee</a></li>
		<li style='display: inline-block; padding: 2px;'><a
			href="viewemp">View Employees</a></li>
		<li style='display: inline-block; padding: 2px;'><a href="logout">Logout</a></li>
		</li>
	</ul>
</body>