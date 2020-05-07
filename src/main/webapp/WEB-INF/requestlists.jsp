<%--Author: Nikolaj--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@include file="../Includes/Header.inc"%>

<style>
    body {background-color: #174986;}
    container {background-color: #174986;}
    h1 {color: white; text-align: center;}
    p {color: white; text-align: center;}
    input[type=submit] {
        background-color: #3CBC8D;
        color: white;
    }
</style>
<body>
<br>

<div class="shadow p-3 mb-5 bg-white rounded">

    <br>
    <div align="container">
        <h2>Liste over anmodninger:</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                <th>Andmodningens nummer:</th>
                <th>Personens email:</th>
                <th>Carportens bredde: </th>
                <th>Carportens længde</th>
                <th>Carportens beklædning:</th>
                <th>Er skrå tag?:</th>
                <th>Areal på Carporten:</th>
                <th>Tag marteriale:</th>
                <th>Tagets vinkel:</th>
                <th>Skurets længde:</th>
                <th>Skurets bredde:</th>

            </tr>
            </thead>
            <tbody>

                    <c:forEach var="requezt" items="${requestScope.requests}">
             <tr>
                 <td>
                 <form name="review" action="FrontController" method="POST">
                     <input type="hidden" name="taget" value="review">
                     <input type="submit" name="reqID" value="Se forespoergsel ${requezt.requestID}">
                 </form>
                 </td>
                        <td>${requezt.email}</td>
                        <td>${requezt.width} m</td>
                        <td>${requezt.length} m</td>
                        <td>${requezt.cladding}</td>
                        <td>${requezt.rooftype}</td>
                        <td>${requezt.area} m^2</td>
                        <td>${requezt.roofmat}</td>
                        <td>${requezt.slopeangle}</td>
                        <td>${requezt.lengthS} m</td>
                        <td>${requezt.widthS} m</td>
             </tr>
                    </c:forEach>
            </tbody>
        </table>
    </div>


    <br>
</div>

<form align="center" name="tilbage" action="FrontController" method="POST">
    <input type="hidden" name="taget" value="toEmpPage">
    <input type="submit" value="Tilbage" class="btn btn-outline-light" style="color:White">
</form>
</body>

<%@include file="../Includes/Footer.inc"%>
