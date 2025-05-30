<%@page import="mvcbams.entities.Accounts"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Details</title>
<style>
    body {
        background-color: #1e1e2f;
        color: #ffffff;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        margin: 0;
        padding: 40px;
    }

    .account-container {
        max-width: 600px;
        margin: auto;
        background-color: #2e2e3e;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.6);
    }

    h1 {
        color: #00e676;
        border-bottom: 1px solid #444;
        padding-bottom: 10px;
        margin-bottom: 20px;
    }

    p {
        font-size: 16px;
        margin: 10px 0;
        color: #ddd;
    }

    .button {
        margin-top: 30px;
    }

    .button a button {
        background-color: #00bcd4;
        color: #fff;
        border: none;
        padding: 12px 20px;
        border-radius: 8px;
        font-size: 14px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    .button a button:hover {
        background-color: #0097a7;
    }
</style>
</head>
<body>

	<div class="account-container">
	
		<h1>${msg }</h1>
		<h1>Account Details</h1>
		<p><strong>Account ID:</strong> ${account.id }</p>
		<p><strong>Account Type:</strong> ${account.type }</p>
		<p><strong>Account Balance:</strong> ₹${account.balance }</p>
		<p><strong>User Name:</strong> ${account.user.name }</p>
		
		<div class="button">
			<a href="history?id=${account.id }"><button>See Transaction History</button></a>
		</div>
		
	</div>
</body>
</html>
