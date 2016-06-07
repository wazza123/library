<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<meta charset="UTF-8">
<head>
    <title></title>
</head>
<body>
<form action="controller" method="post">
    <h2>registration</h2><br><br>
    <input type="hidden" name="command" value="registration">
    login <input type="text" name="login"><br>
    password <input type="password" name="password"><br>
    confirm password <input type="password" name="password1"><br>
    <input type="submit" value="sign up" onclick="return formValid()">

</form>
<p style="color:red">${error_message}</p>
</body>
</html>