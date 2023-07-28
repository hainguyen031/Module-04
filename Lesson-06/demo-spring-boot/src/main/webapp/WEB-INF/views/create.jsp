<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 7/28/2023
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create customer</title>
</head>
<body>
<h1>Create customer</h1>
<p>
    <a href="/customers">Customer list</a>
</p>

<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>

<form action="${pageContext.request.contextPath}/create-customer" method="post">
    <table>
        <tr>
            <td>First name:</td>
            <td><input type="text" name="firstName" value="${customer.firstName}"/></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><input type="text" name="lastName" value="${customer.lastName}"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create customer"></td>
        </tr>
    </table>
</form>

</body>
</html>
