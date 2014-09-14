<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>
</head>
<body>
	<p>You are a user</p>
	<table>
		<tr>
			<th>User</th>
			<th>Date</th>
		</tr>
		<c:forEach var="visit" items="${visitList}">
			<tr>
				<td>${visit.getUser().getUsername()}</td>
				<td>${visit.getDate()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>