<%@ page import="no.kalli.UrlMapping" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registrer</title>
</head>
<body>

<h1>Registrer</h1>
<c:if test="${flash == 'success'}">
    <p style="color: #016936;">${melding}</p>
    <c:remove var="flash" scope="session"/>
</c:if>
<c:if test="${flash == 'error'}">
    <p style="color: #B03060;">${melding}</p>
    <c:remove var="flash" scope="session"/>
</c:if>

<form action="<%=UrlMapping.REGISTRER_URL%>" method="post">
    <fieldset>
        <legend>Registrer</legend>
        <c:if test="${not empty registrerStudentSkjema.navnFeilmelding}">
            <p style="color: #B03060;">${registrerStudentSkjema.navnFeilmelding}</p>
            <c:remove var="registrerStudentSkjema" scope="session"/>
        </c:if>
        <p><input type="text" name="navn" value="${registrerStudentSkjema.navn}" placeholder="Navn"></p>

        <c:if test="${not empty registrerStudentSkjema.klasseKodeFeilmelding}">
            <p style="color: #B03060;">${registrerStudentSkjema.klasseKodeFeilmelding}</p>
            <c:remove var="registrerStudentSkjema" scope="session"/>
        </c:if>
        <p><select name="klasseKode">
            <c:forEach items="${klasser}" var="k">
                <option
                    ${registrerStudentSkjema.klasseKode eq k.kode ? 'selected="selected"' : ''}
                        value="${k.kode}">${k.kode + " " + k.program}
                </option>
            </c:forEach>
        </select></p>

        <c:if test="${not empty registrerStudentSkjema.passordFeilmelding}">
            <p style="color: #B03060;">${registrerStudentSkjema.passordFeilmelding}</p>
            <c:remove var="registrerStudentSkjema" scope="session"/>
        </c:if>
        <p><input type="password" name="passord" value="${registrerStudentSkjema.passord}" placeholder="Passord"></p>
        <p><input type="submit" value="Registrer"></p>
    </fieldset>
</form>

</body>
</html>
