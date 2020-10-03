<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp"/>

<h1>New transaction</h1>
<h3>Due to the current situation in the country, the commission for transfers is 1% of the transfer amount</h3>

<form:form action="/wallet/new-transaction"  method="post" accept-charset="UTF-8" >
    <div class="form-group">
        <label for="inputReceiver">Receiver</label>
        <input type="text" class="form-control" name="receiverWallet" id="inputReceiver"
               placeholder="Enter receiver username">
    </div>
    <div class="form-group">
        <label for="inputAmount">Transaction amount</label>
        <input type="text" class="form-control" name="value" id="inputAmount"
               placeholder="Enter your transaction amount">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form:form>

<jsp:include page="footer.jsp"/>