<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<meta charset="UTF-8">
<head>
    <title></title>
</head>
<body>
<form action="controller" method="post">
 login <input type="text" name="login"><br>
 password  <input type="password" name="password"><br>
  <input type="hidden" name="command" value="authorization">
  <input type="submit" value="sign in">
  </form>
<p id="msg" style="color:red">${error_message}</p>
<a href="registration.jsp">sign up</a>
</body>
</html>
