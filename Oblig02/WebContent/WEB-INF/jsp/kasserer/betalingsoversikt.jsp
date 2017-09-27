<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="static no.hvl.dat104.controller.UrlMappings.KASSERERLOGIN_URL" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Betalingsoversikt</title>
</head>
<body>
	<h2>Betalingsoversikt</h2>
	<form>
		<table border="1">
			<tr bgcolor="#cccccc">
				<th align="left">Navn</th>
				<th>Mobil</th>
				<th>Betalingsstatus</th>
			</tr>
			<tr>
				<td>Arne And</td>
				<td>123 45 678</td>
				<td align="center">Betaling mottatt</td>
			</tr>
			<tr>
				<td>Arne Arnesen</td>
				<td>901 23 456</td>
				<td><input type="submit" name="90123456"
					value="Registrer betaling" /></td>
			</tr>
			<tr>
				<td>Berit Beritsen</td>
				<td>876 54 321</td>
				<td><input type="submit" name="87654321"
					value="Registrer betaling" /></td>
			</tr>
		</table>
	</form>
	<p>
		<a href="<%= KASSERERLOGIN_URL %>">Ferdig</a>
	</p>
</body>
</html>