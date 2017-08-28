<%@ page import="java.util.Currency" %>
<%@ page import="no.hvl.dat104.ValutaService" %>
<%@ page import="no.hvl.dat104.Valuta" %><%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 28.08.2017
  Time: 12.55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Valutaomformer</title>
</head>
<body>
<form action="result">
  <fieldset>
    <legend>Valutaomformer:</legend>
    <p>
      Beløp:
      <input
              type="number"
              name="belop"
              placeholder="Beløp"
      >
      <select name="fra">
        <% for(Valuta v : ValutaService.lesFraFil("/resources/valuta.csv")) { %>
        <option value="<%=v.getKode()%>"><%=v.getNavn()%></option>
        <%}%>
      </select>
    </p>
    <p>
      Skal veksle til:
      <select name="til">
        <% for(Valuta v : ValutaService.lesFraFil("/resources/valuta.csv")) { %>
        <option value="<%=v.getKode()%>"><%=v.getNavn()%></option>
        <%}%>
      </select>
    </p>
    <p><input type="submit" value="Beregn"></p>
  </fieldset>
</form>
</body>
</html>
