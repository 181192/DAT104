<%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 11.09.2017
  Time: 13.23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="handleliste" scope="request" type="java.util.List"/>
<html>
<head>
    <title>Min Handleliste</title>
</head>
<body>
<fieldset>
    <legend>Min Handleliste</legend>
    <form action="handleliste" method="post">
        Legg Til: <input name="vare" placeholder="Vare" autofocus>
        <input type="submit" name="submit" value="Submit">
        <c:forEach var="vare" items="${handleliste}">
            <p>
                <input type="hidden" name="vare" value="${vare.item}">
                <input type="submit" name="submit" value="Slett">: ${vare.item}
            </p>
        </c:forEach>
    </form>
</fieldset>
</body>
</html>
