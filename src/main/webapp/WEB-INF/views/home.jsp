<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 08.08.19
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        <%@include file="/WEB-INF/resources/style.css" %>
    </style>
    <link href="<c:url value="/WEB-INF/resources/style.css" />" rel="stylesheet">
    <title>Title</title>
</head>
<body>
welcome!
<p><a href="/admin">sign in</a></p>
<p><a href="/create">register</a></p>
</body>
</html>
