<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"/>

<h1>Error</h1>

<div>${message}</div>

<!-- вариант с кнопкой -->
<input type="button" onclick="history.back();" value="Back"/>

<jsp:include page="footer.jsp"/>