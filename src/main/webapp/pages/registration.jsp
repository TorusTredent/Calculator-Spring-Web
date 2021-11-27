<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 24.11.2021
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/registration" method="post">
    <input type="text" name="name" placeholder="Name">
    <input type="text" name="username" placeholder="Username">
    <input type="password" name="password" placeholder="Password">
    <button>Submit</button>
</form>
<a href="/"><button>Back</button></a>
<c:if test="${alert != null}">
    ${alert}
</c:if>
</body>
</html>
