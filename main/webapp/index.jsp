<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <h2>Вход в систему</h2><br><br>
  <form action="controller">
    Логин <input type="text" name="login"><br>
    Пароль <input type="password" name="password"><br>
    <input type="hidden" name="command" value="authorization">
    <input type="submit">
  </form>
  <h6><a href="registration.jsp">регистрация</a></h6>
  </body>
</html>
