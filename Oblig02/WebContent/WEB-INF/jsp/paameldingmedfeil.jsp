<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>P�melding</title>
</head>
<body>
	<h2>P�melding</h2>
	<form action="paameldingsbekreftelse.html">
		<fieldset>
			<legend>Personlige data</legend>
			<p>
				Fornavn: <input type="text" name="fornavn" value="" /> <font
					color="red">Kan ikke v�re tomt</font>
			</p>
			<p>
				Etternavn: <input type="text" name="etternavn" value="Arnesen" />
			</p>
			<p>
				Mobil (8 siffer): <input type="text" name="mobil" value="" /> <font
					color="red">M� v�re 8 siffer</font>
			</p>
			<p>
				Kj�nn: <input type="radio" name="kjonn" value="mann"
					checked="checked" />mann <input type="radio" name="kjonn"
					value="kvinne" />kvinne
			</p>
			<p>
				<input type="submit" value="Meld meg p�" />
			</p>
		</fieldset>
	</form>
</body>
</html>