<%@ page import="no.kalli.Attributter" %>
<%@ page import="no.kalli.UrlMapping" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Registrer</title>
</head>
<body>

<h1>Registrer</h1>
<c:if test="${flash == 'success'}">
        <p style="color: #016936;">${melding}</p>
    <c:remove var="flash" scope="session" />
</c:if>
<c:if test="${flash == 'error'}">
        <p style="color: #B03060;">${melding}</p>
    <c:remove var="flash" scope="session" />
</c:if>

<form action="<%=UrlMapping.REGISTRER_URL%>" method="post">
    <fieldset>
        <legend>Registrer</legend>
        <input type="text" name="navn">
        <select name="klasse">
            <c:forEach  items="${klasser}" var = "k">
                <option value="${k.kode}">${k.kode + " " + k.program}</option>
            </c:forEach>
        </select>
        <input type="password" name="passord">
    </fieldset>
</form>

</body>
</html>
