<%--
  Created by IntelliJ IDEA.
  User: Ирина
  Date: 23.02.2017
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Journal</title>
</head>
<body>

<h1>Edit lections. Journal</h1>
<a href="/students/logout">Выход</a>
<form action="/students/editJournal" method="post">
    <input type="hidden" name="id" id="id" value="${Journal.id}">
    <table border="1">
        <tr>
            <td><label for="id_group">Группа</label></td>
            <td><input type="text" name="id_group" id="id_group" value="${Journal.id_group}"><br></td>
            <td><label name="name_group" id="name_group">${Journal.name_group}</label><br></td>
        </tr>
        <tr>
            <td><label for="id_lesson">Лекция</label></td>
            <td><input type="text" name="id_lesson" id="id_lesson" value="${Journal.id_lesson}"><br></td>
            <td><label name="name_lection" id="name_lection">${Journal.name_lection}</label><br></td>
        </tr>
        <tr>
            <td><label for="date_lec">Дата лекции:</label></td>
            <td><input type="text" name="date_lec" id="date_lec" value="${Journal.date_lec}"><br></td>
        </tr>
        <tr>
            <td><label for="time_lec">Время лекции:</label></td>
            <td><input type="text" name="time_lec" id="time_lec" value="${Journal.time_lec}"><br></td>
        </tr>
    </table>
    <input type="submit" value="Редактировать" formmethod="post">
    <input type="button" value="Назад" onclick="history.back()">
</form>


</body>
</html>
