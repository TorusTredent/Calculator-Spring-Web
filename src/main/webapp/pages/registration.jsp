<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
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
<s:form action="/user/registration" method="post" modelAttribute="newUser">
    <s:input path="name" placeholder="Name"/>
    <br>
    <s:errors path="name"/>
    <br>
    <s:input path="username" placeholder="Username"/>
    <br>
    <s:errors path="username"/>
    <br>
    <s:input path="password" placeholder="Password"/>
    <br>
    <s:errors path="password"/>
    <br>
    <s:button>Submit</s:button>
</s:form>
<a href="/"><button>Back</button></a>
<c:if test="${alert != null}">
    ${alert}
</c:if>
</body>
</html>
