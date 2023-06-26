<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of employees</title>
</head>
<body>
<h1>List of employees</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Full name</th>
        <th>Date of birth</th>
        <th>Address</th>
        <th>Position</th>
        <th>Department</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.fullName}</td>
            <td>${employee.dateOfBirth}</td>
            <td>${employee.address}</td>
            <td>${employee.position}</td>
            <td>${employee.department}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
