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
    <title>Edit Customer</title>
    <style>
        h1,div {
            text-align: center;
        }
        table {
            margin: auto;
        }
        .button {
            text-align: right;
        }

    </style>
</head>
<body>
<h1>Edit Customer</h1>
<div>
    <a href="${contextPath}/getCustomer">List Customer</a>
</div><br>
<form:form action="${contextPath}/submit-edit-customer/${customer.customerId}" modelAttribute="customer">
    <table>
        <tr>
            <td>First Name: </td>
            <td><form:input path="firstname"/></td>
        </tr>
        <tr>
            <td>Last Name: </td>
            <td><form:input path="lastname"/></td>
        </tr>
        <tr>
            <td>Birth date: </td>
            <td><form:input type="date" path="birthdate"/></td>
        </tr>
        <tr>
            <td>Phone: </td>
            <td><form:input path="phone"/></td>
        </tr>
        <tr>
            <td>Address: </td>
            <td><form:input path="address"/></td>
        </tr>
        <tr>
            <td>City: </td>
            <td><form:input path="city"/></td>
        </tr>
        <tr>
            <td>State: </td>
            <td><form:input path="state"/></td>
        </tr>
        <tr>
            <td>Points: </td>
            <td><form:input type="number" path="points"/></td>
        </tr>
        <tr>
            <td></td>
            <td class="button"><input type="submit" value="Edit" /></td>
        </tr>
    </table>

</form:form>

</body>
</html>
