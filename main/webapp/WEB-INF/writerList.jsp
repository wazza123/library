<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="writer" varStatus="status" items="${writers}">
  <form action="controller" method="post">
    <input type="hidden" name="book_id" value="${book_id}">
    <img src="${writer.writerPhotoPath}" height="65" width="40"/>
    <input type="hidden" name="command" value="add_book_author">
    <input type="hidden" name="writer_id" value="${writer.id}">
    <input class="book" type="submit" name="last_name" value="${writer.firstName}">
    <input class="book" type="submit" name="last_name" value="${writer.lastName}">
    <input type="submit" value="add author">
  </form>
</c:forEach>
<c:if test="${empty writers}">
  nothing to show. Add writer first<br>
  <a href="addWriter">add writer</a>
</c:if>