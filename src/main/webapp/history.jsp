<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transaction History</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #1e1e2f;
            color: #ffffff;
            margin: 0;
            padding: 40px;
        }

        .transaction-container {
            max-width: 1000px;
            margin: auto;
            padding: 30px;
            background-color: #2e2e3e;
            border-radius: 12px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.5);
        }

        h2 {
            color: #00e676;
            margin-top: 30px;
            margin-bottom: 10px;
            border-bottom: 1px solid #444;
            padding-bottom: 5px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 30px;
            background-color: #393953;
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            padding: 12px 15px;
            text-align: center;
            color: #ddd;
        }

        th {
            background-color: #444c63;
            color: #00bcd4;
        }

        tr:nth-child(even) td {
            background-color: #3c3c50;
        }

        tr:hover td {
            background-color: #4d4d66;
        }

        @media (max-width: 768px) {
            table, th, td {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>
    <div class="transaction-container">
        <h2>Credited History:</h2>
        <table>
            <tr>
                <th>From Account</th>
                <th>To Account</th>
                <th>Amount</th>
                <th>Timestamp</th>
            </tr>
            <c:forEach var="txn" items="${received}">
                <tr>
                    <td>${txn.fromaccount.id}</td>
                    <td>${txn.toaccount.id}</td>
                    <td>${txn.amount}</td>
                    <td>${txn.timestamp}</td>
                </tr>
            </c:forEach>
        </table>

        <h2>Debited History:</h2>
        <table>
            <tr>
                <th>From Account</th>
                <th>To Account</th>
                <th>Amount</th>
                <th>Timestamp</th>
            </tr>
            <c:forEach var="txn" items="${send}">
                <tr>
                    <td>${txn.fromaccount.id}</td>
                    <td>${txn.toaccount.id}</td>
                    <td>${txn.amount}</td>
                    <td>${txn.timestamp}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
