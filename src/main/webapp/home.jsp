<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Home</title>
</head>
<body>
    <h1>HOME</h1>
    <%
        session = request.getSession(false);
        if (session != null) {
            String username = (String) session.getAttribute("username");
    %>
    Bienvenue, <%= username %> !
    <%
        }
    %>
</body>