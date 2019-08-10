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
            <c:forEach items="${sharesToChoose}" var="share">
                <td>
                    <div>Amount of <c:out value="${share.name}"/>:</div><form:input path="userConcreteShares" type="number"/></br>
                    <form:errors path="financialResources" cssClass="error" />
                </td>
            </c:forEach>
        </tr>
        <tr>

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
