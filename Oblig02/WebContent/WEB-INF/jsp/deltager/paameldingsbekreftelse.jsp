<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="static no.hvl.dat104.controller.UrlMappings.DELTAGERLISTE_URL"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p>
		&nbsp;&nbsp;&nbsp;${regDeltager.fornavn}<br />
		&nbsp;&nbsp;&nbsp;${regDeltager.etternavn}<br />
		&nbsp;&nbsp;&nbsp;${regDeltager.mobil}<br />
		&nbsp;&nbsp;&nbsp;${regDeltager.erMann ? 'mann' : 'kvinne'}
	</p>
	<p>
		<b>NB! Husk å betale til kassereren før festen!</b>
	</p>
	<a href="<%=DELTAGERLISTE_URL%>">Gå til deltagerlisten</a>
</body>
</html>