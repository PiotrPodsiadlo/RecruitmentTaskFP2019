<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 08.08.19
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
create user:
<form:form method="post" action="/create" modelAttribute="user">
    <table>
        <tr>
            <td>
                <div>Name of user:</div><form:input path="name" type="text" /></br>
                <form:errors path="name" cssClass="error" />
            </td>
            <td>
                <div>password:</div><form:input path="password" type="text" /></br>
                <form:errors path="password" cssClass="error" />
            </td>
            <td>
                <div>money in PLN:</div><form:input path="financialResources" type="number"/></br>
                <form:errors path="financialResources" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>
                <div>FP SHARES:</div><form:input path="quantityFP" type="number"/></br>
                <form:errors path="quantityFP" cssClass="error" />
            </td>
            <td>
                <div>FPL SHARES:</div><form:input path="quantityFPL" type="number"/></br>
                <form:errors path="quantityFPL" cssClass="error" />
            </td>
            <td>
                <div>FPC SHARES:</div><form:input path="quantityFPC" type="number"/></br>
                <form:errors path="quantityFPC" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>
                <div>PGB SHARES:</div><form:input path="quantityPGB" type="number"/></br>
                <form:errors path="quantityPGB" cssClass="error" />
            </td>
            <td>
                <div>FPA SHARES:</div><form:input path="quantityFPA" type="number"/></br>
                <form:errors path="quantityFPA" cssClass="error" />
            </td>
            <td>
                <div>DL24 SHARES:</div><form:input path="quantityDL24" type="number"/></br>
                <form:errors path="quantityDL24" cssClass="error" />
            </td>
            <td>
                <div>
                    <input type="submit" value="Save">
                </div>
            </td>
        </tr>
    </table>

</form:form>
</body>
</html>
