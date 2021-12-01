<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 26.11.2021
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<c:if test="${user != null}">
    <s:form action="/calculate" method="post" modelAttribute="newOperation">
        <s:input path="num1" placeholder="Number 1"/>
        <br>
        <s:errors path="num1"/>
        <br>
        <s:select path="manipulation">
            <option disabled selected>operation</option>
            <option value="sum">+</option>
            <option value="sub">-</option>
            <option value="div">/</option>
            <option value="multiply">*</option>
        </s:select>
        <br>
        <s:errors path="manipulation"/>
        <br>
        <s:input path="num2" placeholder="Number 2"/>
        <br>
        <s:errors path="num2"/>
        <br>
        <button>Calculate</button>
    </s:form>
    <label>
        <a href="/">
            <button>Back</button>
        </a>
    </label>
    <c:if test="${operationList != null}">
        <ol>
            <c:forEach var="operation" items="${operationList}">
                <li><c:out value="${operation}"/></li>
            </c:forEach>
        </ol>
    </c:if>
</c:if>
</body>
</html>
