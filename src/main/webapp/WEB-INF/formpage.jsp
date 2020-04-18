<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
Author: Vibeke
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <title>Form Print</title>
    <meta charset="utf-8">
    <style>
        body {background-color: #174986;}
        h1 {color: white; text-align: center}
        p {color: white; text-align: center}
    </style>
</head>
<body>

<h1>Din bestilling</h1>
<form action="FrontController" method="POST">
    <select name="country">
        <option value="India">IND</option>
        <option value="America">US</option>
    </select>
    <input type="submit" name="taget" value="form">
</form>
<p>Test 1: ${requestScope.country}</p>
<br>
<p>Width: ${requestScope.bot}</p>
<p>Length: ${requestScope.length}</p>
<p>Roof: ${requestScope.roof}</p>
<p>Slope: ${requestScope.slope}</p>
<p>Shed width: ${requestScope.shedW}</p>
<p>Shed length: ${requestScope.shedL}</p>

<div style="text-align: center">
    <form name="form" action="FrontController" method="POST">
        <input type="hidden" name="taget" value="toindex">
        <button type="submit"class="btn btn-primary">Tilføj ændring</button>
    </form>
</div>

</body>
</html>
