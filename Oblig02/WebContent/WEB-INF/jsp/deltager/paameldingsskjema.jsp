<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Påmelding</title>
</head>
<body>
	<h2>Påmelding</h2>
	<form action="paameldingsbekreftelse.html">
		<fieldset>
			<legend>Personlige data</legend>
			<p>
				Fornavn: <input type="text" name="fornavn" value="Arne" />
			</p>
			<p>
				Etternavn: <input type="text" name="etternavn" value="Arnesen" />
			</p>
			<p>
				Mobil (8 siffer): <input type="text" name="mobil" value="90123456" />
			</p>
			<p>
				Kjønn: <input type="radio" name="kjonn" value="mann"
					checked="checked" />mann <input type="radio" name="kjonn"
					value="kvinne" />kvinne
			</p>
			<p>
				<input type="submit" value="Meld meg på" />
			</p>
		</fieldset>
	</form>
</body>
</html>