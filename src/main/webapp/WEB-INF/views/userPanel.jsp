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

<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/resources/style.css" %>
    </style>
</head>
<body>


    <div style="border: black solid">
        aaa
        <div style="float:left">
            <h2>  Stocks</h2>
        </div>
        <div style="float:right">
            <h2> <c:out value="logged in as ${user.getUsername()}"/></h2>
        </div>
    </br>
    </div>


    <div style="float: left">
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
                    <tr>
                        <td class="tg-0lax"><c:out value="${share.name}"/></td>
                        <td class="tg-0lax"><c:out value="${share.unitPrice}"/></td>
                        <td class="tg-0lax">buy</td>
                    </tr>
                </c:forEach>


            </table>

        </table>
    </div>

    <div style="float: right">
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

                <tr>
                    <td class="tg-0lax">FP</td>
                    <td class="tg-0lax"><c:out value="${FP.unitPrice}"/></td>
                    <td class="tg-0lax"><c:out value=" ${realUser.quantityFP}"/></td>
                    <td class="tg-0lax"><c:out value=" ${realUser.quantityFP * FP.unitPrice}"/></td>
                    <td class="tg-0lax">sell</td>
                </tr>
                <tr>
                    <td class="tg-0lax">FPL</td>
                    <td class="tg-0lax"><c:out value="${FPL.unitPrice}"/></td>
                    <td class="tg-0lax"><c:out value=" ${realUser.quantityFPL}"/></td>
                    <td class="tg-0lax"><c:out value=" ${realUser.quantityFPL * FPL.unitPrice}"/></td>
                    <td class="tg-0lax">sell</td>
                </tr>
                <tr>
                    <td class="tg-0lax">FPC</td>
                    <td class="tg-0lax"><c:out value="${FPC.unitPrice}"/></td>
                    <td class="tg-0lax"><c:out value=" ${realUser.quantityFPC}"/></td>
                    <td class="tg-0lax"><c:out value=" ${realUser.quantityFPC * FPC.unitPrice}"/></td>
                    <td class="tg-0lax">sell</td>
                </tr>
                <tr>
                    <td class="tg-0lax">PGB</td>
                    <td class="tg-0lax"><c:out value="${PGB.unitPrice}"/></td>
                    <td class="tg-0lax"><c:out value=" ${realUser.quantityPGB}"/></td>
                    <td class="tg-0lax"><c:out value=" ${realUser.quantityPGB * PGB.unitPrice}"/></td>
                    <td class="tg-0lax">sell</td>
                </tr>
                <tr>
                    <td class="tg-0lax">FPA</td>
                    <td class="tg-0lax"><c:out value="${FPA.unitPrice}"/></td>
                    <td class="tg-0lax"><c:out value=" ${realUser.quantityFPA}"/></td>
                    <td class="tg-0lax"><c:out value=" ${realUser.quantityFPA * FPA.unitPrice}"/></td>
                    <td class="tg-0lax">sell</td>
                </tr>
                <tr>
                    <td class="tg-0lax">DL24</td>
                    <td class="tg-0lax"><c:out value="${DL24.unitPrice}"/></td>
                    <td class="tg-0lax"><c:out value=" ${realUser.quantityDL24}"/></td>
                    <td class="tg-0lax"><c:out value=" ${realUser.quantityDL24 * DL24.unitPrice}"/></td>
                    <td class="tg-0lax">sell</td>
                </tr>


                <tr>
                    <th class="tg-0lax" colspan="5">Available Money: <c:out value=" ${realUser.financialResources}"/> </th>
                </tr>
            </table>

        </table>
    </div>

</body>
</html>
