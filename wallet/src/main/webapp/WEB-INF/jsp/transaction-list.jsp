<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"/>
<h1>Your are the sender</h1>

<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Receiver</th>
        <th scope="col">Value</th>
        <th scope="col">Commission</th>
        <th scope="col">Confirmed</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${youSender}" var="transactions">
        <tr>
            <th scope="row">---</th>
            <td>${transactions.receiverWallet}</td>
            <td>${transactions.value}</td>
            <td>${transactions.commission}</td>
            <c:if test="${transactions.stamp=='0'}">
                <td>Not confirmed</td>
            </c:if>
            <c:if test="${transactions.stamp!='0'}">
                <td>Confirmed</td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>

</table>

<h1>You receiver</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Sender</th>
        <th scope="col">Value</th>
        <th scope="col">Confirmed</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${youReceiver}" var="transactions">
        <tr>
            <th scope="row">---</th>
            <td>${transactions.senderWallet}</td>
            <td>${transactions.value}</td>
            <c:if test="${transactions.stamp=='0'}">
                <td>Not confirmed</td>
            </c:if>
            <c:if test="${transactions.stamp!='0'}">
                <td>Confirmed</td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>


<h1>Your refills</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Card Number</th>
        <th scope="col">Amount</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${topUp}" var="transactions">
        <tr>
            <th scope="row">---</th>
            <td>${transactions.cardNumber}</td>
            <td>${transactions.amount}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jsp:include page="footer.jsp"/>