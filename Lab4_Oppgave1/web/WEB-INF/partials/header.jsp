<%@ page import="static no.hvl.dat104.controller.UrlMappings.LOGOUT_URL" %>
<%@ page import="static no.hvl.dat104.controller.UrlMappings.REGISTER_URL" %>
<%@ page import="static no.hvl.dat104.controller.UrlMappings.LOGIN_URL" %><%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 14.09.2017
  Time: 14.51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" %>
<html>
<head>
    <title>Handleliste</title>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/style.css">
</head>
<body>
<div>
    <a href="<%= LOGOUT_URL %>">Logg ut</a>
    <a href="<%= REGISTER_URL %>">Registrer</a>
    <a href="<%= LOGIN_URL %>">Logg inn</a>
</div>