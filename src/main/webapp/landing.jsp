<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Landing</title>
</head>
<body>
	<h1>Welcome to mvc Bams</h1>
	<div class="login-container">
	<h2>${msg }</h2>
		<form action="login" method="post">
			<label for="email">Enter Email:</label>
			<input type="text" id="email" name="email" required="required">
			
			<label for="password">Enter Password:</label>
			<input type="text" id="password" name="password" required="required"> 
			
			<button type="submit">Login</button>
			<div class="sub-container">
				<label for="register">Don't have an account?</label>
				<a href="register.jsp">Register</a>
			</div>
		</form>
	</div>
	
</body>
</html>