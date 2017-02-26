<%--
  Created by IntelliJ IDEA.
  User: Ирина
  Date: 23.02.2017
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>Add journal</title>
</head>
<body>
<h1>Edit journal</h1>
<form action="/students/addJournal" method="post">
    <input type="hidden" name="journalID" id="journalID" value="${Journal.id}">
    <table border="1">
        <tr>
            <td><label for="idGroup">Группа</label></td>
            <td><input type="text" name="idGroup" id="idGroup" value="${Journal.id_group}"><br></td>
        </tr>
        <tr>
            <td><label for="idLection">Лекция</label></td>
            <td><input type="text" name="idLection" id="idLection" value="${Journal.id_lesson}"><br></td>
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
</form>

</body>
</html>
