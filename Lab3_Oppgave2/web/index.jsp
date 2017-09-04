<%@ page import="no.hvl.dat104.Options" %>
<%@ page import="no.hvl.dat104.Votes" %><%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 30.08.2017
  Time: 21.49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    Votes v = (Votes) request.getSession().getAttribute("votes");
    Options o = (Options) request.getSession().getAttribute("options");
%>
<html>
<head>
    <title>Favorittfrukt</title>
</head>
<body>
<form action="result" method="POST">
    <fieldset>
        <legend>Din favorittfrukt</legend>
        <table>
            <tr>
                <% for (int i = 0; i < o.getAlternatives().size(); i++) { %>
                <% if (i > 0 && i % 5 == 0) { %>
            </tr>
            <tr>
                <% } %>
                <td>
                    <label>
                        <input type="radio" name="frukt" value="<%= i %>">
                        <%= o.getAlternatives().get(i) %>
                    </label>
                </td>
                <% } %>
            </tr>
        </table>
        <p>
            <input type="submit" value="Stem">
        </p>
    </fieldset>
</form>
</body>
</html>
