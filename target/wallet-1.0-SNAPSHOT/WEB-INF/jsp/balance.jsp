<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<div >
    <h2>Your balance: ${balance}$</h2>
</div>



<form action="/wallet/balance"  method="post" accept-charset="UTF-8" >
    <div class="form-group">

        <label for="enterCardNumber">Enter your card</label>
        <input type="text" class="form-control" name="cardNumber" id="enterCardNumber"
               placeholder="1234 5678 9012 3456">
        <label for="enterAmount">Enter the top-up amount</label>
        <input type="text" class="form-control" name="amount" id="enterAmount"
               placeholder="For example: 50 ">
    </div>
    <button type="submit" class="btn btn-primary">Transfer money</button>
</form>
<jsp:include page="footer.jsp"/>