<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Form</title>
</head>
<body>
	<div align="center">
		<h1>Contact Info From</h1>

		<font color='green'>${succMsg}</font> <font color='red'>${errMsg}</font>

		<form:form action="saveContact" method="POST" modelAttribute="contact">
			<div>
				<table>
					<tr>
						<td>Contact Name</td>
						<td><form:input path="contactName" /></td>
						<form:hidden path="contactId" />
					</tr>

					<tr>
						<td>Contact Email</td>
						<td><form:input path="contactEmail" /></td>
					</tr>

					<tr>
						<td>Contact PhNo</td>
						<td><form:input path="contactPhNo" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Save Contact" /></td>
					</tr>
				</table>
			</div>
		</form:form>
		<a href="viewContacts">View All Contacts</a>
	</div>

</body>
</html>