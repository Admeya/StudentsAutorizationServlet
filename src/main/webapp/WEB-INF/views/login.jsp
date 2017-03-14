<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Login</title>
</head>
<body>
<a href="/students/registration">Регистрация</a>
<div>
    <c:url value="/j_spring_security_check" var="loginUrl"/>
    <form action="${loginUrl}" method="post">
        <input type="text" name="j_username" placeholder="Login" value="">
        <input type="password" name="j_password" placeholder="Password" required value="">
        <button type="submit">Войти</button>
    </form>
</div>

</body>
</html>