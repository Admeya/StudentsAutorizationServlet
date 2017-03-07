<%--
  Created by IntelliJ IDEA.
  User: bot
  Date: 23.02.17
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">Страница регистрации</h1>
<div align="center">
    <form action="/students/registration" method="post">
        <table>
            <tr>
                <td><label for="login">Login:</label></td>
                <td><input type="text" name="login" id="login" value="" placeholder="Input"></td>
            <tr>
                <td><label for="password">Password:</label></td>
                <td><input type="password" name="password" id="password" value="" placeholder="Input"></td>
            </tr>
        </table>
        <input type="submit" value="Submit" formmethod="post">
    </form>
    <input type="button" value="Назад" onclick="history.back()">
</div>
</body>
</html>