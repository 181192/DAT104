<%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 06.09.2017
  Time: 15.20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set
        var="language"
        value="${ not empty param.language ? param.language : pageContext.request.locale
        }"
        scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="no.hvl.dat104.i18n.text"/>
<html lang="${language}">
<head>
    <title><fmt:message key="greetings.title.result"/></title>
    <link href="https://fonts.googleapis.com/css?family=Raleway:400,700" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/main.css">
</head>
<body>
<fieldset>
    <legend><fmt:message key="greetings.title.result"/></legend>
    <p>
        <fmt:message key="greetings.hello"/> <strong><%= request.getSession().getAttribute("name") %>
    </strong>!
        <br>
        <br>
        <a href="${pageContext.request.contextPath}"><fmt:message key="greetings.again"/></a>
    </p>
</fieldset>
</body>
</html>
