<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<c:if test="${success}">
		<p style="color:green;">Registered successfully!</p>
	</c:if>
	<c:if test="${fail}">
		<p style="color:red;">No such username or password!</p>
	</c:if>
	<form action="LoginUser" method="post">
		Username: <input type="text" name="username" autofocus required> <br>
		Password: <input type="password" name="password" required> <br>
		<input type="submit" value="Login">
	</form>
</body>
</html>