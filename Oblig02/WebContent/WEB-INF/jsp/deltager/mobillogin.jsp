<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
	import="static no.hvl.dat104.controller.UrlMappings.MOBILLOGIN_URL"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logg inn</title>
</head>
<body>
	<h2>Logg inn</h2>
	<p>Det er kun registrerte deltagere som får se deltagerlisten. Logg
		inn ved å gi mobil-nummeret ditt.</p>
	<c:if test="${flash == 'auth'}">
		<p style="color: red;">${flash_melding}</p>
		<c:remove var="flash" scope="session" />
	</c:if>
	<form action="<%=MOBILLOGIN_URL%>" method="post">
		<fieldset>
			<legend>Logg inn</legend>
			<p>
				Mobil: <input type="password" name="password" placeholder="passord" />
				<c:if test="${flash == 'error'}">
					<span style="color: red;">${flash_melding}</span>
					<c:remove var="flash" scope="session" />
				</c:if>
			</p>
			<p>
				<input type="submit" value="Logg inn" />
			</p>
		</fieldset>
	</form>

</body>
</html>