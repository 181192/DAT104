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
		&nbsp;&nbsp;&nbsp;Arne<br /> &nbsp;&nbsp;&nbsp;Arnesen<br />
		&nbsp;&nbsp;&nbsp;90123456<br /> &nbsp;&nbsp;&nbsp;mann
	</p>
	<p>
		<b>NB! Husk � betale til kassereren f�r festen!</b>
	</p>
	<a href="<%= DELTAGERLISTE_URL %>">G� til deltagerlisten</a>
</body>
</html>