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
<a href="/students/logout">Выход</a>
<h1>List of lections. Journal</h1>
<table border="1">
    <tr>
        <th>Journal id</th>
        <th>id_group</th>
        <th>id_lection</th>
        <th> Group name</th>
        <th> Lection name</th>
        <th> Date lection</th>
        <th> Time lection</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${journalList}" var="journal">
        <tr>
            <td><c:out value="${journal.id}"></c:out></td>
            <td><c:out value="${journal.id_group}"></c:out></td>
            <td><c:out value="${journal.id_lesson}"></c:out></td>
            <td><c:out value="${journal.name_group}"></c:out></td>
            <td><c:out value="${journal.name_lection}"></c:out></td>
            <td><c:out value="${journal.date_lec}"></c:out></td>
            <td><c:out value="${journal.time_lec}"></c:out></td>
            <td><a href="/students/editJournal?idJournal=${journal.id}">Редактировать </a><a
                    href="/students/listLection?idJournal=${journal.id}">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
<form action="/students/addJournal.jsp" method="post">
    <input type="submit" value="Добавить" formmethod="post">
    <input type="button" value="Назад" onclick="history.back()">
</form>


</body>
</html>
