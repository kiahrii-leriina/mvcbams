<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Landing</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #1e1e2f;
        color: #ffffff;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
    }

    h1 {
        font-size: 2rem;
        margin-bottom: 20px;
    }

    .login-container {
        background-color: #2e2e3e;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.6);
        width: 320px;
    }

    h2 {
        color: #ff6f61;
        text-align: center;
        margin-bottom: 20px;
    }

    label {
        display: block;
        margin-bottom: 5px;
        font-size: 0.95rem;
        color: #cccccc;
    }

    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: none;
        border-radius: 5px;
        background-color: #444;
        color: #fff;
        font-size: 1rem;
    }

    input[type="text"]:focus, input[type="password"]:focus {
        outline: none;
        box-shadow: 0 0 5px #007acc;
    }

    button {
        width: 100%;
        padding: 10px;
        background-color: #007acc;
        color: white;
        border: none;
        border-radius: 5px;
        font-size: 1rem;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    button:hover {
        background-color: #005fa3;
    }

    .sub-container {
        text-align: center;
        margin-top: 15px;
        font-size: 0.9rem;
    }

    .sub-container a {
        color: #00bcd4;
        text-decoration: none;
        font-weight: bold;
        margin-left: 5px;
    }

    .sub-container a:hover {
        text-decoration: underline;
    }
</style>
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
