<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false" %>
<html>
<head>
    <title></title>
    <fmt:setLocale value="${sessionScope.locale}"  />
    <fmt:setBundle basename="localization.local" var="loc" />
    <fmt:message bundle="${loc}" key="local.errorMessage" var="error" />
</head>
<body>
<script>
    alert("${error}")
    document.location.href = '/index.jsp'
</script>

</body>
</html>