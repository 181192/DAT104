<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<p>Det er kun registrerte deltagere som f�r se deltagerlisten. Logg
		inn ved � gi mobil-nummeret ditt.</p>
	<form action="<%=MOBILLOGIN_URL%>" method="post">
		<fieldset>
			<legend>Logg inn</legend>
			<p>
				Mobil: <input type="password" name="password" placeholder="passord" />
			</p>
			<p>
				<input type="submit" value="Logg inn" />
			</p>
		</fieldset>
	</form>

</body>
</html>