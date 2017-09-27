<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="static no.hvl.dat104.controller.UrlMappings.BETALINGSOVERSIKT_URL" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kasserer login</title>
</head>
<body>
	<h2>Kasserer login</h2>
	<form action="<%= BETALINGSOVERSIKT_URL %>" method="post">
		<fieldset>
			<legend>Kasserer login</legend>
			<p>
				Passord: <input type="password" name="password" value="allstars" />
			</p>
			<p>
				<input type="submit" value="Logg inn" />
			</p>
		</fieldset>
	</form>

</body>
</html>