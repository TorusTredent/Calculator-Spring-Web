<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form action="${pageContext.request.contextPath}/calculator/calculate" method="post">
        <input type="text" name="num1" placeholder="Number 1">
        <label>
            <select name="operation">
                <option disabled selected>operation</option>
                <option value="sum">+</option>
                <option value="sub">-</option>
                <option value="div">/</option>
                <option value="multiply">*</option>
            </select>
        </label>
        <input type="text" name="num2" placeholder="Number 2">
        <button>Calculate</button>
    </form>
    <c:if test="${alert != null}">
        ${alert}
    </c:if>
    <c:if test="${message != null}">
        ${message}
    </c:if>
    <label>
        <form action="${pageContext.request.contextPath}/calculator/showHistory" method="get">
            <button>Show</button>
        </form>
        <form action="${pageContext.request.contextPath}/calculator/hideHistory" method="get">
            <button>Hide</button>
        </form>
    </label>
    <label>
        <a href="/"><button>Back</button></a>
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
