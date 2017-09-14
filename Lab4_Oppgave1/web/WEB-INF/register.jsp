<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="static no.hvl.dat104.controller.UrlMappings.REGISTER_URL" %><%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 14.09.2017
  Time: 14.50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" %>
<jsp:include page="./partials/header.jsp"/>
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
    <legend>Registrer</legend>
    <form action="<%= REGISTER_URL %>" method="post">
        <p><input name="username" placeholder="Brukernavn" autofocus></p>
        <p><input type="password" name="password" placeholder="Passord"></p>
        <p><input type="submit" name="register" value="Registrer"></p>
    </form>
</fieldset>
<jsp:include page="./partials/footer.jsp"/>
