<%@ page import="static no.hvl.dat104.controller.UrlMappings.SHOPPING_LIST_URL" %><%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 11.09.2017
  Time: 13.23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="shoppingList" scope="request" type="java.util.List"/>
<html>
<head>
    <title>Min Handleliste</title>
</head>
<body>
<fieldset>
    <legend>Min Handleliste</legend>
    <form action="<%= SHOPPING_LIST_URL %>" method="post">
        Legg Til: <input name="vare" placeholder="Vare" autofocus>
        <input type="submit" name="submit" value="Submit">
    </form>
    <c:forEach var="item" items="${shoppingList}">
        <form action="<%= SHOPPING_LIST_URL %>" method="post">
            <input type="hidden" name="vare" value="${item.item}">
            <input type="submit" name="submit" value="Slett">: ${item.item}
        </form>
    </c:forEach>
</fieldset>
</body>
</html>
