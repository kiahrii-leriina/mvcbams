<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transfer Money</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #1e1e2f;
        color: #ffffff;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .transfer-container {
        background-color: #2e2e3e;
        padding: 30px 40px;
        border-radius: 12px;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.6);
        width: 400px;
    }

    h1 {
        color: #ff9800;
        text-align: center;
        margin-bottom: 25px;
        font-size: 1.5rem;
    }

    label {
        display: block;
        margin-top: 15px;
        font-size: 0.95rem;
        color: #cccccc;
    }

    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        border: none;
        border-radius: 5px;
        background-color: #444;
        color: #fff;
        font-size: 1rem;
    }

    input:focus {
        outline: none;
        box-shadow: 0 0 5px #007acc;
    }

    button {
        width: 100%;
        padding: 12px;
        margin-top: 25px;
        background-color: #007acc;
        color: white;
        border: none;
        border-radius: 6px;
        font-size: 1rem;
        font-weight: bold;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    button:hover {
        background-color: #005fa3;
    }
</style>
</head>
<body>

	<div class="transfer-container">
		<h1>${msg }</h1>
		<form action="transfer" method="post">
			<label for="fromid">Enter Your Account ID:</label>
			<input id="fromid" type="text" name="fromaccountid" required="required">
			
			<label for="toid">Enter Receiver's Account ID:</label>
			<input id="toid" type="text" name="toaccountid" required="required">
			
			<label for="amount">Enter Transfer Amount:</label>
			<input id="amount" name="amount" type="text" required="required">

			<button type="submit">Transfer</button>			
		</form>
	</div>
</body>
</html>
