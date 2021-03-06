<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 08.08.19
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/resources/style.css" %>
    </style>
</head>
<body>



    <div >

        <div style="float:left">
            <h2>  Stocks</h2>
        </div>
        <div style="float:right">
            <h2> <c:out value="logged in as ${user.getUsername()}"/> <a href="/edit"> edit profile </a> <a href="/login?logout"> logout </a> </h2>
        </div>
    </br>
    </br>
    </br>
    </div>


    <div style="float: left" class="operationtable">
        <table>
            <table class="tg">
                <tr>
                    <th class="tg-0lax" colspan="3">Stock prices</th>
                </tr>
                <tr>
                    <td class="tg-2wmj">Company</td>
                    <td class="tg-m71n">Value</td>
                    <td class="tg-m71n">Actions</td>
                </tr>
                <c:forEach items="${shares}" var="share">
                     <C:if test="${share.quantity>0}">
                        <tr>
                            <td class="tg-0lax"><c:out value="${share.name}"/></td>
                            <td class="tg-0lax"><c:out value="${share.unitPrice}"/></td>
                            <td class="tg-0lax">
                                <form:form method="post" action="/buy/${share.id}" modelAttribute="user">
                                    <button type="submit" onclick="return confirm('Do you confirm buying actions?')">buy</button>
                                </form:form>
                            </td>
                        </tr>
                     </C:if>
                </c:forEach>


            </table>

        </table>
    </div>

    <div style="float: right" class="operationtable">
        <table>
            <table class="tg">
                <tr>
                    <th class="tg-0lax" colspan="5">My wallet</th>
                </tr>
                <tr>
                    <td class="tg-2wmj">Company</td>
                    <td class="tg-m71n">Unit price</td>
                    <td class="tg-m71n">Amount</td>
                    <td class="tg-m71n">Value</td>
                    <td class="tg-m71n">Actions</td>
                </tr>

                <c:forEach items="${shares}" var="share">
                    <C:if test="${realUser.shares.stream().filter(elem -> elem.id.equals(share.id)).count()>0}">
                        <tr>
                            <td class="tg-0lax"><c:out value="${share.name}"/></td>
                            <td class="tg-0lax"><c:out value="${share.unitPrice}"/></td>
                            <td class="tg-0lax"><c:out value="${realUser.shares.stream().filter(elem -> elem.id.equals(share.id)).count()}"/></td>
                            <td class="tg-0lax"><c:out value="${realUser.shares.stream().filter(elem -> elem.id.equals(share.id)).count() * share.unitPrice}"/></td>
                            <td class="tg-0lax">
                                <form:form method="post" action="/sell/${share.id}" modelAttribute="user">
                                    <button type="submit" onclick="return confirm('Do you confirm selling actions?')">sell</button>
                                </form:form>
                            </td>
                        </tr>
                    </C:if>
                </c:forEach>
                <tr>
                    <th class="tg-0lax" colspan="5">Available Money: <c:out value=" ${realUser.financialResources}"/> </th>
                </tr>
            </table>

        </table>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script>
        <%@include file="/WEB-INF/resources/app.js" %>
    </script>





</body>
</html>
