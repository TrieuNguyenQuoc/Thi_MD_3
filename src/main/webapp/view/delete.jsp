<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: Quốc Triệu
  Date: 7/05/2023
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Xóa </h1>
<form action="home" method="post">
    <input type="text" name="di" value="${requestScope.id}">
    <input type="text" name="classroom" value="delete">
    <input type="submit" value="Xóa">
</form>
<form action="home" method="get">
    <input type="text" name="id" value="${requestScope.id}">
    <input type="text" name="clasroom" value="">
    <input type="submit" value="Không">
</form>
</body>
</html>
