<%--
  Created by IntelliJ IDEA.
  User: thutn
  Date: 10/20/20
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Submit Create Customer</title>
    <style>
        h1, div {
            text-align: center;
        }
        table {
            margin: auto;
        }
    </style>
</head>
<body>
<h1>Created Customer</h1>
<div>
    <a href="${contextPath}/getCustomer">List Customer</a> |
    <a href="${contextPath}/create-customer">Create Customer</a>
</div><br>
    <table>
        <tr>
            <td>First Name: </td>
            <td>${customerDto.firstname}</td>
        </tr>
        <tr>
            <td>Last Name: </td>
            <td>${customerDto.lastname}</td>
        </tr>
        <tr>
            <td>Birth date: </td>
            <td>${customerDto.birthdate}</td>
        </tr>
        <tr>
            <td>Phone: </td>
            <td>${customerDto.phone}</td>
        </tr>
        <tr>
            <td>Address: </td>
            <td>${customerDto.address}</td>
        </tr>
        <tr>
            <td>City: </td>
            <td>${customerDto.city}</td>
        </tr>
        <tr>
            <td>State: </td>
            <td>${customerDto.state}</td>
        </tr>
        <tr>
            <td>Points: </td>
            <td>${customerDto.points}</td>
        </tr>
    </table>

</body>
</html>
