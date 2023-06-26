list.jsp<%--
  Created by IntelliJ IDEA.
  User: duc29
  Date: 6/19/2023
  Time: 7:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Add employee</title>
</head>
<body>
<h1>Add employee</h1>
<form action="${pageContext.request.contextPath}/employee" method="POST">
  <label for="fullName">Full name:</label>
  <input type="text" id="fullName" name="fullName"><br>

  <label for="dateOfBirth">Date of birth:</label>
  <input type="date" id="dateOfBirth" name="dateOfBirth"><br>

  <label for="address">Address:</label>
  <input type="text" id="address" name="address"><br>

  <label for="position">Position:</label>
  <input type="text" id="position" name="position"><br>

  <label for="department">Department:</label>
  <input type="text" id="department" name="department"><br>

  <input type="submit" value="Submit">
  <input type="reset" value="Reset">
</form>
<script>
  document.querySelector("input[type='reset']").addEventListener("click", function() {
    document.querySelector("form").reset();
  });
</script>
</body>
</html>