<%@page import="mvcbams.entities.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
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

        .profile-container {
            background-color: #2e2e3e;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.6);
            width: 600px;
            text-align: center;
        }

        h1 {
            color: #00bcd4;
            font-size: 1.3rem;
            margin-bottom: 10px;
        }

        h2 {
            color: #ffffff;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #393953;
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            padding: 12px 15px;
            text-align: center;
        }

        th {
            background-color: #444c63;
            color: #00e676;
            font-weight: bold;
        }

        td {
            background-color: #3e3e50;
            color: #eeeeee;
        }

        .buttons {
            margin-top: 25px;
            display: flex;
            justify-content: space-between;
            gap: 20px;
        }

        button {
            padding: 12px 20px;
            background-color: #007acc;
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 0.95rem;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #005fa3;
        }

        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="profile-container">
        <h1>${msg }</h1>
        <h2>User Profile</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                </tr>
            </tbody>
        </table>

        <div class="buttons">
            <a href="transfer.jsp"><button>Transfer Money</button></a>	
	        <a href="account?id=${user.id}"><button>Check Account Details</button></a>
        </div>
    </div>
</body>
</html>
