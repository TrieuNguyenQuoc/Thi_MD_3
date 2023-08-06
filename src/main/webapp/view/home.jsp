<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl" %>--%>
<%--
Created by IntelliJ IDEA.
 User: Quốc Triệu
  Date: 7/05/2023
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Trang chủ </h1>
<form action="home" method="get">
    <input type="hidden" name="choice" value="create">
    <input type="submit" value="Thêm">
</form>
<table>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Phone</th>
        <th>birth</th>
        <th>classroom</th>
    </tr>
    <c:forEach var="resultStudent" items="${studenList}">
        <tr>
            <th>${resultStudent.id}</th>
            <th>${resultStudent.name}</th>
            <th>${resultStudent.email}</th>
            <th>${resultStudent.address}</th>
            <th>${resultStudent.phone}</th>
            <th>${resultStudent.birth}</th>
<%--            <th>${resultStudent.classroom}</th>--%>
            <th><a href="home?choice=edit&employee_id=${resultStudent.getid()}">Sửa</a></th>
            <th><a href="home?choice=delete&employee_id=${resultStudent.getid()}">Xóa</a></th>
        </tr>
    </c:forEach>
</table>

<form action="home" method="get">
    <input type="text" name="searchKey" placeholder="search here">
    <input type="submit" name="choice" value="search">
</form>
</body>
</html>
