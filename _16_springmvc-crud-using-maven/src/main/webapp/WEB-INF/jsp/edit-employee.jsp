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
		style='  background: conic-gradient(lightpink, white, powderblue); list-style-type: none; text-align: center; margin: 0; padding: 0; color='ch''>
		<li style='display: inline-block; padding: 2px;'><a 
			href="${pageContext.request.contextPath}/add-employee">Add Employee</a></li>
		<li style='display: inline-block; padding: 2px;'><a
			href="${pageContext.request.contextPath}/viewemp">View Employees</a></li>
		<li style='display: inline-block; padding: 2px;'>
		<a
			href="logout">Logout</a></li>
		</li>
	</ul>
	<form:form method="POST"
		action="${pageContext.request.contextPath}/editsave"
		modelAttribute="populatedEmployee">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Salary :</td>
				<td><form:input path="salary" /></td>
			</tr>
			<tr>
				<td>Designation :</td>
				<td><form:input path="designation" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Edit Save" /></td>
			</tr>
		</table>
	</form:form>
</body>

