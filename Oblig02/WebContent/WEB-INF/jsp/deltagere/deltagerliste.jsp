<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="static no.hvl.dat104.controller.UrlMappings.FERDIG_URL"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table border="1">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
		</tr>
		<c:forEach var="d" items="${deltagere}">
			<tr bgcolor="${innloggetDeltager.mobil eq d.mobil ? (innloggetDeltager.harBetalt ? '#aaffaa' : '#ffaaaa') : ''}">
				<td align="center">${d.erMann ? '&#9794;' : '&#9792;'}</td>
				<td><c:out value="${d.fornavn} ${d.etternavn}" /></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="<%=FERDIG_URL%>">Ferdig</a>
	</p>
</body>
</html>