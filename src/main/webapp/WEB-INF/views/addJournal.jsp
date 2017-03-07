<%--
  Created by IntelliJ IDEA.
  User: Ирина
  Date: 23.02.2017
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add journal</title>
</head>
<body>
<a href="/students/logout">Выход</a>
<h1>Edit journal</h1>
<form action="/students/addJournal" method="post">
    <table border="1">
        <tr>
            <td><label for="id_group">Группа</label></td>
            <td><input type="text" name="id_group" id="id_group" value=""><br></td>
        </tr>
        <tr>
            <td><label for="id_lesson">Лекция</label></td>
            <td><input type="text" name="id_lesson" id="id_lesson" value=""><br></td>
        </tr>
        <tr>
            <td><label for="date_lec">Дата лекции:</label></td>
            <td><input type="text" name="date_lec" id="date_lec" value=""><br></td>
        </tr>
        <tr>
            <td><label for="time_lec">Время лекции:</label></td>
            <td><input type="text" name="time_lec" id="time_lec" value=""><br></td>
        </tr>
    </table>
    <input type="submit" value="Редактировать" formmethod="post">
    <input type="button" value="Назад" onclick="history.back()">
</form>

</body>
</html>
