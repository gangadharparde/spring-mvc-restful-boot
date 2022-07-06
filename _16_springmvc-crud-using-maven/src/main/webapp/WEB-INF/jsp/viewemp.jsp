<%@page contentType="text/html;charset = UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<style>
* {
	font-family: verdana;
	font-size: 9px;
}
</style>
<body>
	<hr>
	Welcome ${fn:toUpperCase(userName)}, What you want to do today?
	<hr>
	<ul
		style='background: conic-gradient(lightpink, white, powderblue); list-style-type: none; text-align: center; margin: 0; padding: 0;'ch''>
		<li style='display: inline-block; padding: 2px;'><a
			href="add-employee">Add Employee</a></li>
		<li style='display: inline-block; padding: 2px;'><a
			href="viewemp">View Employees</a></li>
		<li style='display: inline-block; padding: 2px;'><a href="logout">Logout</a></li>
		</li>
	</ul>
	</br>
	</br>
	<table border="1" width="70%" cellpadding="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Designation</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="emp" items="${list}">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.salary}</td>
				<td>${emp.designation}</td>
				<td><a href="edit-employee/${emp.id}">Edit</a></td>
				<td><a href="deleteemp/${emp.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
</body>