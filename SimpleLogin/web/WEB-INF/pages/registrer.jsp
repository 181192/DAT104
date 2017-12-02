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
        <c:if test="${not empty registrerStudentSkjema.navnFeilmelding}">
            <p style="color: #B03060;">${registrerStudentSkjema.navnFeilmelding}</p>
            <c:remove var="registrerStudentSkjema" scope="session" />
        </c:if>
        <input type="text" name="navn" value="${registrerStudentSkjema.navn}" placeholder="Navn">

        <c:if test="${not empty registrerStudentSkjema.klassekodeFeilmelding}">
            <p style="color: #B03060;">${registrerStudentSkjema.klassekodeFeilmelding}</p>
            <c:remove var="registrerStudentSkjema" scope="session" />
        </c:if>
        <select name="klassekode">
            <c:forEach  items="${klasser}" var = "k">
                <option
                        ${registrerStudentSkjema.klasseKode eq k.kode ? 'selected="selected"' : ''}
                        value="${k.kode}">${k.kode + " " + k.program}
                </option>
            </c:forEach>
        </select>

        <c:if test="${not empty registrerStudentSkjema.passordFeilmelding}">
            <p style="color: #B03060;">${registrerStudentSkjema.passordFeilmelding}</p>
            <c:remove var="registrerStudentSkjema" scope="session" />
        </c:if>
        <input type="password" name="passord" value="${registrerStudentSkjema.passord}" placeholder="Passord">
    </fieldset>
</form>

</body>
</html>
