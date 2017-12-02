<%@ page import="no.kalli.UrlMapping" %><%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 02.12.2017
  Time: 12.36
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="<%=UrlMapping.STUDENTER_URL%>" method="post">
    <fieldset>
      <legend>Registrer</legend>
      <input type="text" name="navn">
      <h1>Studentene: </h1>

      <select name="navn">
        <c:forEach  items="${navn}" var = "navn">
          <p>Navn: </p>
        </c:forEach>
      </select>


    </fieldset>

  </form>
  </body>
</html>
