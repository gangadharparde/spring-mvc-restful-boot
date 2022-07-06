	<!-- JSTL includes, Spring Form Tag -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
    </head>
    <body>
        <h3>Please Enter your Account Details</h3>
        <form:form method="POST"
          action="/addAccount" modelAttribute="account">
             <table>
                <tr>
                    <td><form:label path="id">Id</form:label></td>
                    <td><form:input path="id"/></td>
                </tr>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="type">Account Type</form:label></td>
                    <td><form:input path="type"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>