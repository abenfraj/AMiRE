<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Login</title>
</head>
<body>

<form action="login" method="post">
  <label for="username">Username:</label><br>
  <input type="text" id="username" name="username" required><br><br>
  <label for="password">Password:</label><br>
  <input type="password" id="password" name="password" required><br><br>
  <input type="submit" value="Submit">
</form>

</body>
</html>