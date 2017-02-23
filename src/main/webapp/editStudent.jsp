<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ирина
  Date: 23.02.2017
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<html>
<head>
    <title>Edit student</title>
</head>
<body>
<h1>Edit Student</h1>
<form action="/students/edit" method="post">
<input type="hidden" name="studID" id="studID" value="${studentID.id}">
<table border="1">
    <tr>
        <td><label for="studName">Имя</label></td>
        <td><input type="text" name="studName" id="studName" value="${studentID.name}"><br></td>
    </tr>
    <tr>
        <td><label for="studAge">Возраст</label></td>
        <td><input type="text" name="studAge" id="studAge" value="${studentID.age}"><br></td>
    </tr>
    <tr>
        <td><label for="studIdGroup">Номер группы</label></td>
        <td><input type="text" name="studIdGroup" id="studIdGroup" value="${studentID.id_group}"><br></td>
    </tr>
</table>
<input type="submit" value="Редактировать" formmethod="post">
</form>

</body>
</html>