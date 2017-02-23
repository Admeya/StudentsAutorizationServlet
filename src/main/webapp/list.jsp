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
    <title>List</title>
  </head>
  <body>

  <%request.setCharacterEncoding("UTF-8");%>
  <h1>List of students</h1>
<table border="1">
  <tr>
    <th>Student id</th>
    <th> Student name</th>
    <th> Student age</th>
    <th> Student id_group</th>
    <th> Actions</th>
  </tr>
  <c:forEach items="${studentList}" var="students">
  <tr>
    <td><c:out value="${students.id}"></c:out></td>
    <td><c:out value="${students.name}"></c:out></td>
    <td><c:out value="${students.age}"></c:out></td>
    <td><c:out value="${students.id_group}"></c:out></td>
    <td><a href="/students/edit?idStudent=${students.id}">Редактировать </a><a href="/students/list?idStudent=${students.id}">Удалить</a></td>
  </tr>
  </c:forEach>
</table>
  <form action="/students/addStudent.jsp" method="post">
    <input type="submit" value="add student" formmethod="post">
  </form>

  </body>
</html>
