<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp"/>

    <h1>Search result:</h1>

    <ul class="list-group">
      <c:forEach items="${appUsers}" var="appUser">
      <li class="list-group-item"><c:out value="${appUser}"/></li>
      </c:forEach>
    </ul>


<jsp:include page="footer.jsp"/>