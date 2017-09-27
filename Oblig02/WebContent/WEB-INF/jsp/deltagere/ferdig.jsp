<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="static no.hvl.dat104.controller.UrlMappings.MOBILLOGIN_URL"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ferdig</title>
</head>
<body>
	<h1>Ferdig</h1>
	<p>Du er nå logget ut.</p>
	<p>
		Du kan se deltagerlisten igjen ved å gå <a href="<%= MOBILLOGIN_URL %>">hit</a>.
	</p>
</body>
</html>