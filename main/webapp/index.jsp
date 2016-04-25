<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title></title>
    <fmt:setLocale value="${sessionScope.locale}" />
    <fmt:bundle basename="localization.local" >
      <fmt:message key="local.locbutton.name.en" var="en_button"/>
      <fmt:message key="local.locbutton.name.ru" var="ru_button"/>
      <fmt:message key="local.textfield.login" var="login_text"/>
      <fmt:message key="local.textfield.password" var="password_text"/>
      <fmt:message key="local.loginbutton.name" var="login_button"/>
    </fmt:bundle>

  </head>
  <body>

  <form action="controller" method="post">
    <input type="hidden" name="command" value="localization" />
    <input type="hidden" name="local" value="ru" />
    <input type="submit"
           value="${ru_button}" /><br />
  </form>

  <form action="controller" method="post">
    <input type="hidden" name="command" value="localization" />
    <input type="hidden" name="local" value="en" />
    <input type="submit" value="${en_button}" /><br />
  </form>

  <form action="controller" method="post">
    ${login_text} <input type="text" name="login"><br>
    ${password_text} <input type="password" name="password"><br>
    <input type="hidden" name="command" value="authorization">
    <input type="submit" value="${login_button}">
  </form>

  </body>
</html>
