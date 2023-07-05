<%--
  Created by IntelliJ IDEA.
 User: Quốc Triệu
  Date: 7/05/2023
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Thêm học sinh </h1>
<form action="home" method="post">
    <input type="text" name="id" placeholder="id">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="email" placeholder="email">
    <input type="text" name="address" placeholder="address">
    <input type="text" name="phone" placeholder="phone">
    <input type="text" name="birth" placeholder="birth">
    <input type="text" name="classroom" value="classroom">
    <input type="submit" value="Thêm">
</form>
</body>
</html>
