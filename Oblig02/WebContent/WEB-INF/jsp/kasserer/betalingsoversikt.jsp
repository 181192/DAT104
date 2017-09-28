<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page
	import="static no.hvl.dat104.controller.UrlMappings.KASSERERLOGIN_URL"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Betalingsoversikt</title>
</head>
<body>
	<h2>Betalingsoversikt</h2>
	<c:if test="${flash == 'success'}">
		<span style="color: green;">${flash_melding}</span>
		<c:remove var="flash" scope="session" />
	</c:if>
	<form>
		<table border="1">
			<tr bgcolor="#cccccc">
				<th align="left">Navn</th>
				<th>Mobil</th>
				<th>Betalingsstatus</th>
			</tr>
			<c:forEach var="d" items="${deltagere}">
				<tr>
					<td><c:out value="${d.fornavn} ${d.etternavn}" /></td>
					<td><c:set value="${d.mobil}" var="mobil" /> <c:out
							value="(${fn:substring(mobil, 0, 3} ${fn:substring(mobil, 3, 5} ${fn:substring(mobil, 5, 8})" /></td>
					<td align="center"><c:if test="${d.harBetalt}">
							Betaling mottatt
						</c:if> <c:otherwise>
							<input type="submit" name="${d.mobil}" value="Registrer betaling" />
						</c:otherwise></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<p>
		<a href="<%=KASSERERLOGIN_URL%>">Ferdig</a>
	</p>
</body>
</html>