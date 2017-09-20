<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="static no.hvl.dat104.controller.UrlMappings.LOGIN_URL" %><%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 14.09.2017
  Time: 14.50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" %>
<jsp:include page="./partials/header.jsp"/>
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
<fieldset id="loginForm">
    <legend>Logginn</legend>
    <form action="<%= LOGIN_URL %>" method="post">
        <p><input name="username" placeholder="Brukernavn" autofocus></p>
        <p><input type="password" name="password" placeholder="Passord"></p>
        <p><input type="submit" name="login" value="Logg inn"></p>
    </form>
</fieldset>
<jsp:include page="./partials/footer.jsp"/>
