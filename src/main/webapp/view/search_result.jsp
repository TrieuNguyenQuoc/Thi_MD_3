<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl" %>--%>
<%--
Created by IntelliJ IDEA.
User: Quốc Triệu
  Date: 7/05/2023
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Kết quả học viên </h1>
<table>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Phone</th>
        <th>birth</th>
        <th>classroom</th>
    </tr>
    <c:forEach var="resultStudent" items="${requestScope['studentList']}">
        <tr>
            <th>${resultStudent.id()}</th>
            <th>${resultStudent.name}</th>
            <th>${resultStudent.email}</th>
            <th>${resultStudent.address}</th>
            <th>${resultStudent.phone}</th>
            <th>${resultStudent.birth}</th>
            <th>${resultStudent.classrom}</th>
            <th><a href="home?choice=edit&employee_id=${resultStudent.get.Student()}">Sửa</a></th>
            <th><a href="home?choice=delete&employee_id=${resultStudent.get.Student()}">Xóa</a></th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
