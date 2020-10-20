<jsp:include page="header.jsp"/>

<div>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <sec:authorize access="!isAuthenticated()">
    <h4>You are in the educational project of Nikita Pogodsky. Please log in</h4>
  </sec:authorize>
  <sec:authorize access="isAuthenticated()">
    <h4>You are in the educational project of Nikita Pogodsky. Thank you for attention</h4>
  </sec:authorize>

</div>

<jsp:include page="footer.jsp"/>