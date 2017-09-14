<%@ page import="static no.hvl.dat104.controller.UrlMappings.SHOPPING_LIST_URL" %><%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 11.09.2017
  Time: 13.23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="./partials/header.jsp"/>
<jsp:useBean id="shoppingList" scope="request" type="java.util.List"/>
<jsp:useBean id="message" scope="request" type="java.lang.String"/>
<jsp:useBean id="flash" scope="request" type="java.lang.String"/>
<div>
    <c:if test="${flash == 'Error'}">
        <p style="color:red;"> ${message}</p>
        <c:remove var="flash" scope="session"/>
    </c:if>
    <c:if test="${flash == 'Success'}">
        <p style="color:green;"> ${message}</p>
        <c:remove var="flash" scope="session"/>
    </c:if>
</div>
<fieldset>
    <legend>Min Handleliste</legend>
    <form action="<%= SHOPPING_LIST_URL %>" method="post">
        Legg Til: <input name="newItem" placeholder="Vare" autofocus>
        <input type="submit" name="submit" value="Submit">
    </form>
    <c:forEach var="item" items="${shoppingList}">
        <form action="<%= SHOPPING_LIST_URL %>" method="post">
            <input type="hidden" name="delItem" value="<c:out value="${item.itemId}"/>">
            <input type="submit" name="submit" value="Slett"> <c:out value="${item.item}"/>
        </form>
    </c:forEach>
</fieldset>
<jsp:include page="./partials/footer.jsp"/>
