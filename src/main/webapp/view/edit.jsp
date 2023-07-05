<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: Quốc Triệu
  Date: 7/05/2023
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Sửa </h1>
<form action="home" method="post">
    <input type="text" name="choice" value="edit">
    <input type="hidden" name="id" value="${requestScope.id}">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="email" placeholder="email">
    <input type="text" name="address" placeholder="address">
    <input type="text" name="phone" placeholder="phone">
    <input type="text" name="birth" placeholder="birth">
    <input type="text" name="classroom" placeholder="classroom">
    <input type="submit" value="Sửa">
</form>
</body>
</html>
