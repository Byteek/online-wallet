<jsp:include page="header.jsp"/>
<h1>Registration</h1>

<form action="/wallet/registration" method="post">
    <div class="form-group">
        <label for="inputUsername">User name</label>
        <input type="text" class="form-control" name="username" id="inputUsername"
               placeholder="Enter your username">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-control" name="email" id="exampleInputEmail1"
               aria-describedby="emailHelp" placeholder="Enter email">
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group">
        <label for="inputPassword">User password</label>
        <input type="password" class="form-control" name="userPassword" id="inputPassword"
               placeholder="Enter your password ">
    </div>
    <div class="form-group">
        <label for="inputPhone">Phone Number</label>
        <input type="text" class="form-control" name="phoneNumber" id="inputPhone"
               placeholder="Enter your phone number">
    </div>
    <div class="form-group">
        <label for="exampleFormControlSelect1"> Select the currency for your wallet</label>
        <select class="form-control" name="currency" id="exampleFormControlSelect1">
            <option>USD</option>
        </select>
    </div>
    <div class="form-group">
        <label for="inputKey">Secret key</label>
        <input type="text" class="form-control" name="secretKey" id="inputKey"
               placeholder="Enter the secret key(PIN) that only you know">
    </div>
    <button type="submit" class="btn btn-primary">Registration</button>
</form>
<jsp:include page="footer.jsp"/>