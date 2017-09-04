<%@ page import="no.hvl.dat104.Options" %>
<%@ page import="no.hvl.dat104.Votes" %><%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 04.09.2017
  Time: 21.19
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
    <title>Result</title>
</head>
<body>
<fieldset>
    <legend>Resultat</legend>
    <table>
        <% for (int i = 0; i < o.getAlternatives().size(); i++) { %>
        <tr>
            <td><%= o.getAlternatives().get(i)%>
            </td>
            <td><%= v.getVotes().get(i) %>
            </td>
        </tr>
        <% } %>
    </table>

    <p>
        <a href="${pageContext.request.contextPath}">Stem engang til</a>
    </p>
</fieldset>
</body>
</html>
