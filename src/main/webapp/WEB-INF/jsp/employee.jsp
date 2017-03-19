<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Spring 3 MVC Series - Contact Manager</title>
	<style type="text/css">
		body {
			font-family: sans-serif;
		}
		.data, .data td {
			border-collapse: collapse;
			width: 100%;
			border: 1px solid #aaa;
			margin: 2px;
			padding: 2px;
		}
		.data th {
			font-weight: bold;
			background-color: #5C82FF;
			color: white;
		}
	</style>
</head>
<body>

<h2>Contact Manager</h2>

<form:form method="post" action="add.html" commandName="employee">
	<form:errors path="*" />

	<table>
	<tr>
		<td><form:label path="firstName"><spring:message code="label.firstname"/></form:label></td>
		<td><form:input path="firstName" /></td>
	</tr>
	<tr>
		<td><form:label path="lastName"><spring:message code="label.lastname"/></form:label></td>
		<td><form:input path="lastName" /></td>
	</tr>
	<tr>
		<td><form:label path="email"><spring:message code="label.email"/></form:label></td>
		<td><form:input path="email" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="<spring:message code="label.addcontact"/>"/>
		</td>
	</tr>
</table>	
</form:form>

	
<h3>Employee</h3>
<c:if  test="${!empty contactList}">
<table class="data">
<tr>
	<th>Name</th>
	<th>Email</th>
	<th>&nbsp;</th>
</tr>
<c:forEach items="${contactList}" var="employee">
	<tr>
		<td>${employee.lastName}, ${employee.firstName} </td>
		<td>${employee.email}</td>
		<td><a href="delete/${employee.id}">delete</a></td>
	</tr>
</c:forEach>
</table>
</c:if>


</body>
</html>
