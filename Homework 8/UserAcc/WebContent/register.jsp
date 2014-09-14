<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<c:if test="${exists}">
		<p style="color:red;">A user with this username is already registered.</p>
	</c:if>
	<form action="RegisterUser" method="post">
		Username: <input type="text" name="username" required autofocus> <br>
		Email: <input type="text" name="email" required> <br>
		Password: <input type="password" name="password" required> <br>
		<input type="checkbox" name="isAdmin"> Admin <br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>