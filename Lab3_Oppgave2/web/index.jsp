<%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 30.08.2017
  Time: 21.49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Favorittfrukt</title>
</head>
<body>
<form action="result" method="POST">
    <fieldset>
        <legend>Din favorittfrukt</legend>
        <p>
            <label>Eple
                <input type="radio" name="frukt" value="0">
            </label>
            <label>Pære
                <input type="radio" name="frukt" value="1">
            </label>
            <label>Kiwi
                <input type="radio" name="frukt" value="2">
            </label>
            <label>Banan
                <input type="radio" name="frukt" value="3">
            </label>
        </p>
        <p>
            <input type="submit" value="Stem">
        </p>
    </fieldset>
</form>
</body>
</html>
