<%--
  Created by IntelliJ IDEA.
  User: Mathias
  Date: 30-04-2020
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
@Vibeke
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <title>Request Review</title>
    <meta charset="utf-8">
    <style>
        body {background-color: #174986;}
        h1 {color: white; text-align: center;}
        #info {
            border: 1px solid white;
            border-collapse: collapse;
            width: 100%;
            text-align: center;
        }
        #info td {
            border: 1px solid white;
            border-collapse: collapse;
            width: 50%;
        }
        #info p {
            color: white;
            text-align: center;
        }
        #customer {
            border-bottom: 1px solid white;
            border-collapse: collapse;
            width: 50%;
            text-align: left;
        }
        #customer td {
            border-bottom: 1px solid white;
            border-collapse: collapse;
            width: 50%;
        }
        #customer p {
            color: white;
            text-align: left;
        }
    </style>
</head>
<body>

<div class="container" align="center">
    <img src="Images/fogs.jpg" class="img-fluid">
</div>

<h1>${requestScope.reviewEmail}'s bestilling nummer ${requestScope.reviewID}</h1>
<br>
<div class="container" align="center">
    <table id="info">
        <tr>
            <td><p>Bredde:</p></td>
            <td><p>${requestScope.reviewWidth} cm</p></td>
        </tr>
        <tr>
            <td><p>Længde:</p></td>
            <td><p>${requestScope.reviewLength} cm</p></td>
        </tr>
        <tr>
            <td><p>Tagtype:</p></td>
            <td><p>${requestScope.reviewRoofType}</p></td>
        </tr>
        <tr>
            <td><p>Tagmateriale:</p></td>
            <td><p>${requestScope.reviewRoofMat} cm</p></td>
        </tr>
        <tr>
            <td><p>Areal:</p></td>
            <td><p>${requestScope.reviewArea} cm^2</p></td>
        </tr>
        <tr>
            <td><p>Tagvinkel:</p></td>
            <td><p>${requestScope.reviewSlope} cm</p></td>
        </tr>
        <tr>
            <td><p>Skur længde:</p></td>
            <td><p>${requestScope.reviewLengthS} cm</p></td>
        </tr>
        <tr>
            <td><p>Skur bredde:</p></td>
            <td><p>${requestScope.reviewWidthS} cm</p></td>
        </tr>

    </table>
</div>


<br>
<div class="col" align="center">
    <form align="center" name="tilbage" action="FrontController" method="POST">
        <input type="hidden" name="taget" value="toEmpPage">
        <input type="submit" value="Tilbage" class="btn btn-outline-light" style="color:White">
    </form>

</div>
<br>
<br>


</body>
</html>

