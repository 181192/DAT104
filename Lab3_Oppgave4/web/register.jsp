<%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 08.09.2017
  Time: 22.42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String fname = (String) request.getSession().getAttribute("fname");
    String lname = (String) request.getSession().getAttribute("lname");
%>
<html>
<head>
    <title>Side som husker deg</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/" method="POST">
    <fieldset>
        <legend>Personlige opplysninger</legend>
        <p><label>Fornavn:
            <input
                    name="fname"
                <%= (fname != null) ? "value=\"" + fname + "\"" : "placeholder=\"Fornavn\"" %>
            >
        </label></p>
        <p><label>Etternavn:
            <input
                    name="lname"
                <%= (lname != null) ? "value=\"" + lname + "\"" : "placeholder=\"Etternavn\"" %>
            >
        </label></p>
        <input type="submit" value="Registrer">
    </fieldset>
</form>
</body>
</html>
