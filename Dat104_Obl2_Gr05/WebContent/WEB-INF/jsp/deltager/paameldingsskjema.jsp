<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="static no.hvl.dat104.controller.UrlMappings.PAAMELDING_URL"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Påmelding</title>
</head>
<body>
	<h2>Påmelding</h2>
	<c:if test="${flash == 'error'}">
		<p style="color: red;">${flash_melding}</p>
		<c:remove var="flash" scope="session" />
	</c:if>
	<form action="<%=PAAMELDING_URL%>" method="post">
		<fieldset>
			<legend>Personlige data</legend>
			<p>
				Fornavn: <input type="text" name="fornavn" value="${fornavn}" /> <span
					style="color: red;">${feilfornavn}</span>
			</p>
			<p>
				Etternavn: <input type="text" name="etternavn" value="${etternavn}" />
				<span style="color: red;">${feiletternavn}</span>
			</p>
			<p>
				Mobil (8 siffer): <input type="text" name="mobil" value="${mobil}" />
				<span style="color: red;">${feilmobil}</span>
			</p>
			<p>
				Kjønn: <input type="radio" name="kjoenn" value="mann"
					checked="checked" />mann <input type="radio" name="kjoenn"
					value="kvinne" />kvinne
			</p>
			<p>
				<input type="submit" value="Meld meg på" />
			</p>
		</fieldset>
	</form>
</body>
</html>