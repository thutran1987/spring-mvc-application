<%--
  Created by IntelliJ IDEA.
  User: thutn
  Date: 10/19/20
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>All Customers</title>
    <style>
        table {
            border: solid 1px;
            border-collapse: collapse;
            margin: auto;
        }
        th, td {
            border: solid 1px;
        }
        h1, div {
            text-align: center;
        }
    </style>
</head>
<body>
<h1>List Customer</h1>
<div>
    <a href="${contextPath}/create-customer">Create Customer</a>
</div> <br/>
<table>
    <tr>
        <th>Customer Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Birth date</th>
        <th>Phone</th>
        <th>Address</th>
        <th>City</th>
        <th>State</th>
        <th>Points</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.customerId}</td>
            <td>${customer.firstname}</td>
            <td>${customer.lastname}</td>
            <td>${customer.birthdate}</td>
            <td>${customer.phone}</td>
            <td>${customer.address}</td>
            <td>${customer.city}</td>
            <td>${customer.state}</td>
            <td>${customer.points}</td>
            <td><a href="${contextPath}/edit-customer/${customer.customerId}">Edit</a> | <a href="${contextPath}/delete-customer/${customer.customerId}">Delete</a> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
