<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Login</title>
</head>
<body>
<div>
  <a href="/students/registration">Регистрация</a>

  <form action="/students/choise" method="post">
    <label for="login">Login:</label>
    <input type="text" name="login" id="login" value="" >
    <label for="password">Password:</label>
    <input type="password" name="password" id="password" value="" >

    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>