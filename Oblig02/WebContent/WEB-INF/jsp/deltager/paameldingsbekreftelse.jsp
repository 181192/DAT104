<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="static no.hvl.dat104.controller.UrlMappings.DELTAGERLISTE_URL"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>P�meldingsbekreftelse</title>
</head>
<body>
	<h2>P�meldingsbekreftelse</h2>
	<p>P�meldingen er mottatt for</p>
	<p>
		&nbsp;&nbsp;&nbsp;${regDeltager.fornavn}<br />
		&nbsp;&nbsp;&nbsp;${regDeltager.etternavn}<br />
		&nbsp;&nbsp;&nbsp;${regDeltager.mobil}<br />
		&nbsp;&nbsp;&nbsp;${regDeltager.erMann ? 'mann' : 'kvinne'}
	</p>
	<p>
		<b>NB! Husk � betale til kassereren f�r festen!</b>
	</p>
	<a href="<%=DELTAGERLISTE_URL%>">G� til deltagerlisten</a>
</body>
</html>