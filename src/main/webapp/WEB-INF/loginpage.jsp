<%--
@Vibeke
En simpel loginside hvor medarbejdere hos Fog kan logge ind.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <title>Login Side</title>
    <meta charset="utf-8">
    <style>
        body {background-color: #174986;}
        h1 {color: white; text-align: center;}
        h2 {color: white; text-align: center;}
        p {color: white; text-align: center;}
    </style>
</head>
<body>
<div class="container" align="center">

    <img src="Images/fogs.jpg" class="img-fluid">

    <div class="col-4"></div>

    <div class="col-4">
        <h1 align="center">Login</h1>
        <form name="login" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="login">


            <div class="form-group">
                <input type="email" name="email" class="form-control" value="email">
            </div>

            <div class="form-group">
                <input type="password" name="password" class="form-control" value="password">
            </div>

            <button type="submit" class="btn btn-primary">Login</button>
        </form>
    </div>

    <div class="col-4"></div>

</div>

<br>
<br>
<br>

<div class="container" align="center">
    <c:if test = "${requestScope.error!= null}" >

        <h2>Error ! </h2>
        <p>${requestScope.error}</p>

    </c:if>
</div>

</body>
</html>
