<%--
  Created by IntelliJ IDEA.
  User: Ирина
  Date: 23.02.2017
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<html>
  <head>
      <title>Add student</title>
  </head>
  <body>
  <a href="/students/logout">Выход</a>
  <h1>Edit Student</h1>
  <spring:form action="/students/addStudent" method="post" modelAttribute="student">
    <table border="1">
      <tr>
        <td><label for="name">Имя</label></td>
        <td><input type="text" name="name" id="name" value=""><br></td>
      </tr>
      <tr>
        <td><label for="age">Возраст</label></td>
        <td><input type="text" name="age" id="age" value=""><br></td>
      </tr>
      <tr>
        <td><label for="id_group">Номер группы</label></td>
        <td><input type="text" name="id_group" id="id_group" value=""><br></td>
      </tr>
    </table>
    <input type="submit" value="Добавить" formmethod="post">
      <input type="button" value="Назад" onclick="history.back()">
  </spring:form>
  </body>
</html>
