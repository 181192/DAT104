<%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 30.08.2017
  Time: 10.16
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
    <title><fmt:message key="hello.legend.title"/></title>
    <link href="https://fonts.googleapis.com/css?family=Raleway:400,700" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/main.css">
</head>
<body>
<form action="greetings" method="POST">
    <fieldset>
        <legend><fmt:message key="hello.legend.title"/></legend>
        <label for="name"><fmt:message key="hello.label.name"/>:</label>
        <input name="name" id="name" placeholder="<fmt:message key="hello.label.name" />">
        <br>
        <br>
        <br>
        <br>
        <fmt:message key="hello.button.submit" var="buttonValue"/>
        <input type="submit" name="submit" value="${buttonValue}">
    </fieldset>
</form>
</body>
</html>
