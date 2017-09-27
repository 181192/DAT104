<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page
	import="static no.hvl.dat104.controller.UrlMappings.PAAMELDING_URL"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Påmelding</title>
</head>
<body>
	<h2>Påmelding</h2>
	<form action="<%= PAAMELDING_URL %>" method="post">
		<fieldset>
			<legend>Personlige data</legend>
			<p>
				Fornavn: <input type="text" name="fornavn" placeholder="fornavn" />
			</p>
			<p>
				Etternavn: <input type="text" name="etternavn" placeholder="etternavn" />
			</p>
			<p>
				Mobil (8 siffer): <input type="text" name="mobil" placeholder="mobil" />
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