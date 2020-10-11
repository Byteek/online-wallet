<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!doctype html>
<html lang="en">
<head>
    <%--    content="width=device-width, initial-scale=1, shrink-to-fit=no,application/json"--%>
    <!-- Required meta tags -->
    <meta charset="utf-8" content="application/json ">
    <meta name="viewport">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <title>Wallet version 1.0.1 </title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/wallet/home"><h2>Wallet</h2></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/wallet/home">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    User`s menu
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/wallet/new-transaction">New Transaction</a>
                    <a class="dropdown-item" href="/wallet/transaction-list">Transaction list</a>
                    <a class="dropdown-item" href="/wallet/balance">Balance</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/wallet/mining">Run mining</a>
                </div>
                <sec:authorize access="!isAuthenticated()">
            <li class="nav-item">
                <a class="nav-link" href="/wallet/login" tabindex="1">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/wallet/registration" tabindex="1">Registration</a>
            </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link " href="/wallet/balance" tabindex="1">Balance</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/wallet/logout" tabindex="1">Logout</a>
                </li>
            </sec:authorize>

            </li>
        </ul>
        <%--      <form class="form-inline my-2 my-lg-0" action="/wallet/search.html">--%>
        <%--        <input class="form-control mr-sm-2" type="search" name="search" placeholder="Search" aria-label="Search">--%>
        <%--        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--%>
        <%--      </form>--%>
    </div>
</nav>