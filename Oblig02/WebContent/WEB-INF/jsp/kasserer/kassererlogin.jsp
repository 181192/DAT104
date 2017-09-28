<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
	import="static no.hvl.dat104.controller.UrlMappings.KASSERERLOGIN_URL"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kasserer login</title>
</head>
<body>
	<h2>Kasserer login</h2>
	<form action="<%=KASSERERLOGIN_URL%>" method="post">
		<fieldset>
			<legend>Kasserer login</legend>
			<p>
				Passord: <input type="password" name="password"
					placeholder="passord" />
				<c:if test="${flash == 'error'}">
					<span style="color: red;">${flash_melding}</span>
					<c:remove var="flash" scope="session" />
				</c:if>
			</p>
			<p>
				<input type="submit" value="Logg inn" />
			</p>
		</fieldset>
	</form>

</body>
</html>