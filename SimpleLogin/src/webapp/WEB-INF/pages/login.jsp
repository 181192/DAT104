<%@ page import="static no.kalli.UrlMapping.LOGIN_URL" %><%--
  Created by IntelliJ IDEA.
  User: krist
  Date: 02.12.2017
  Time: 14.35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="<%=LOGIN_URL%>" method="post">

    <div class="container">
        <label><b>StudentNr</b></label>
        <input type="text" placeholder="Enter StudentNr" name="id" required>

        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required>

        <button type="submit">Login</button>
        <input type="checkbox" checked="checked"> Remember me
    </div>

    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn">Cancel</button>
        <span class="psw">Forgot <a href="#">password?</a></span>
    </div>



</form>

</body>
</html>
