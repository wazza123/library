<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title></title>
    <fmt:setLocale value="${sessionScope.locale}"  />
    <fmt:setBundle basename="localization.local" var="loc" />
    <fmt:message bundle="${loc}" key="local.message" var="message" />
    <fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button" />
    <fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button" />
    <fmt:message bundle="${loc}" key="local.logoutbutton.name" var="logout_button" />
</head>
<body>

<form action="controller" method="post">
    <input type="hidden" name="command" value="localization" />
    <input type="hidden" name="local" value="ru" />
    <input type="submit" value="${ru_button}" /><br />
</form>
<form action="controller" method="post">
    <input type="hidden" name="command" value="localization" />
    <input type="hidden" name="local" value="en" />
    <input type="submit" value="${en_button}" /><br />
</form>

${message}
<form action="controller" method="post">
<input type="hidden" name="command" value="logout">
<input type="submit" value="${logout_button}"> <br>

</form>
</body>
</html>