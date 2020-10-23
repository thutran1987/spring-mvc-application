<%--
  Created by IntelliJ IDEA.
  User: thutn
  Date: 10/20/20
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Delete Customer</title>
    <style>
        h1,div,h3 {
            text-align: center;
        }
        table {
            margin: auto;
        }
        .button {
            text-align: right;
        }
        h3 {
            color: red;
        }

    </style>
</head>
<body>
<h1>Delete Customer</h1>
<h3>Are you sure want to delete this customer?</h3>
<div>
    <a href="${contextPath}/getCustomer">List Customer</a>
</div><br>
<form:form action="${contextPath}/submit-delete-customer/${customer.customerId}" modelAttribute="customer">
    <table>
        <tr>
            <td>First Name: </td>
            <td>${customer.firstname}</td>
        </tr>
        <tr>
            <td>Last Name: </td>
            <td>${customer.lastname}</td>
        </tr>
        <tr>
            <td>Birth date: </td>
            <td>${customer.birthdate}</td>
        </tr>
        <tr>
            <td>Phone: </td>
            <td>${customer.phone}</td>
        </tr>
        <tr>
            <td>Address: </td>
            <td>${customer.address}</td>
        </tr>
        <tr>
            <td>City: </td>
            <td>${customer.city}</td>
        </tr>
        <tr>
            <td>State: </td>
            <td>${customer.state}</td>
        </tr>
        <tr>
            <td>Points: </td>
            <td>${customer.points}</td>
        </tr>
        <tr>
            <td></td>
            <td class="button"><input type="submit" value="Delete" name="action" /> <input type="submit" value="Cancel" name="action"/> </td>
        </tr>
    </table>

</form:form>

</body>
</html>
