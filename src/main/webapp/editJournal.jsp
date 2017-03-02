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
    <input type="hidden" name="journalID" id="journalID" value="${Journal.id}">
    <table border="1">
        <tr>
            <td><label for="idGroup">Группа</label></td>
            <td><input type="text" name="idGroup" id="idGroup" value="${Journal.id_group}"><br></td>
            <td><label name="nameGroup" id="nameGroup">${Journal.name_group}</label><br></td>
        </tr>
        <tr>
            <td><label for="idLection">Лекция</label></td>
            <td><input type="text" name="idLection" id="idLection" value="${Journal.id_lesson}"><br></td>
            <td><label name="nameLection" id="nameLection">${Journal.name_lection}</label><br></td>
        </tr>
        <tr>
            <td><label for="dateLection">Дата лекции:</label></td>
            <td><input type="text" name="dateLection" id="dateLection" value="${Journal.date_lec}"><br></td>
        </tr>
        <tr>
            <td><label for="timeLection">Время лекции:</label></td>
            <td><input type="text" name="timeLection" id="timeLection" value="${Journal.time_lec}"><br></td>
        </tr>
    </table>
    <input type="submit" value="Редактировать" formmethod="post">
    <input type="button" value="Назад" onclick="history.back()">
</form>


</body>
</html>
