<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>

	<div class="register-container">
		<form action="register" method="post">
			<label for="name">Enter Name:</label>
			<input type="text" id="name" name="name" required="required"> 
			
			<label for="email">Enter Email:</label>
			<input type="text" id="email" name="email" required="required">
			
			<label for="password">Enter Password:</label>
			<input type="text" id="password" name="password" required="required"> 
			
			<label for="phone">Enter Phone</label>
			<input type="text" id="phone" name="phone" required="required">
		
			<button type="submit">Register</button>	
		</form>
	</div>
</body>
</html>