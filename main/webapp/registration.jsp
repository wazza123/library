<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<meta charset="UTF-8">
<head>
    <title></title>
    <script type="text/javascript"><%@include file="WEB-INF/scripts/registrationFormValidation.js"%></script>
</head>
<body>
<form action="controller" method="post">
    <h2>registration</h2><br><br>
    <input type="hidden" name="command" value="registration">
    login <input id="login" type="text" name="login"><br>
    password <input id="password" type="password" name="password"><br>
    confirm password <input id="password1" type="password" name="password1"><br>
    <input type="submit" value="sign up" onclick="return registrationFormIsValid()">
</form>
<p id="msg" style="color:red">${error_message}</p>
</body>
</html>