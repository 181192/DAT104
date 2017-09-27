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
		&nbsp;&nbsp;&nbsp;Arne<br /> &nbsp;&nbsp;&nbsp;Arnesen<br />
		&nbsp;&nbsp;&nbsp;90123456<br /> &nbsp;&nbsp;&nbsp;mann
	</p>
	<p>
		<b>NB! Husk å betale til kassereren før festen!</b>
	</p>
	<a href="<%= DELTAGERLISTE_URL %>">Gå til deltagerlisten</a>
</body>
</html>