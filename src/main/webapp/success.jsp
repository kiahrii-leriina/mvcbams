<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction Success</title>
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
        color: #00e676;
        font-size: 2rem;
        margin-bottom: 20px;
    }

    p {
        background-color: #2e2e3e;
        padding: 20px 30px;
        border-radius: 10px;
        box-shadow: 0 0 12px rgba(0, 0, 0, 0.5);
        font-size: 1.1rem;
        color: #e0e0e0;
        text-align: center;
    }
</style>
</head>
<body>

	<h1>Transaction Success</h1>
	<p>
		Transaction info:<br>
		From Account: <strong>${transaction.fromaccount.id}</strong><br>
		To Account: <strong>${transaction.toaccount.id}</strong><br>
		Amount: <strong>₹${transaction.amount}</strong>
	</p>

</body>
</html>
