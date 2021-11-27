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
    <title>Home</title>
</head>
<body>
<c:if test="${user == null}">
    <a href="${pageContext.request.contextPath}/user/registration">Registration</a>
    <a href="${pageContext.request.contextPath}/user/authorization">Authorization</a>
</c:if>
<c:if test="${user != null}">
    <a href="${pageContext.request.contextPath}/calculator/calculate">Calculator</a>
    <a href="${pageContext.request.contextPath}/user/logout">Logout</a>
</c:if>
</body>
</html>
