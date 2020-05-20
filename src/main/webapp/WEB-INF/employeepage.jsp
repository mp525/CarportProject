<%-- 
@Vibeke
@Matti
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fog Ansat</title>
        <style>
            body {background-color: #174986;}
            h1 {color: white; text-align: center;}
            h2 {color: white; text-align: center;}
            p {color: white; text-align: center;}
            label{color: white; text-align: center;}
            input{text-align: center;}
        </style>
    </head>
    <body>

    <div class="container" align="center">
        <img src="Images/fogs.jpg" class="img-fluid">


    </div>
    <h2 align="center">Liste med anmodninger</h2>

    <div style="text-align: center;display: block">
        <form name="requestLists" style="display: inline-block; margin-left: auto; margin-right: auto; text-align: left" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="requestLists">
            <button type="submit" class="btn btn-primary">Gå til liste over alle anmodninger</button>
        </form>
    </div>

    </div>



    <br>
    <br>
    <h2 align="center">Søg på requests via specific mail</h2>
    <div style="text-align: center;display: block">
        <form name="getOnesRequests" action="FrontController" align="center">
            <input type="hidden" name="taget" value="getOnesRequests">
            <label for="uzi">Se en specific email's tilhørende anmodninger:</label><br>
            <input type="email" id="uzi" name="emaill" value="Indtast kontaktens Email"><br>
            <br>
            <%--        <input type="submit" value="Slet">--%>
            <button align="center" type="submit" class="btn btn-primary">Søg på denne mail</button>
        </form>
    </div>
    </div>

    <div class="container" align="center">
        <c:if test = "${requestScope.error!= null}" >

            <h2>Error ! </h2>
            <p>${requestScope.error}</p>

        </c:if>
    </div>
<br>
<br>
    <h2 align="center">Tilføj nyt materiale</h2>


    <div class="col" align="center">
        <form name="newMaterial" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="newMaterialPage">
            <input type="submit" value="Tilføj nyt materiale til systemet" class="btn btn-light">
        </form>

    </div>
    <br>
    <br>
    <br>

    </body>
    <br>
    <br>
    
    <footer class="shadow-lg p-3 mb-5 bg-black rounded">
        <div align="center">
            <blockquote class="blockquote text-right">
                <p class="mb-0"><h1>Hej ${sessionScope.email} </h1>

                <p>Du er logget ind som ansat.</p><p>

            </blockquote>
            <br>
            <br>

            <form name="logout" action="FrontController" method="POST">
                <input type="hidden" name="taget" value="logout">
                <input type="submit" value="Logout" class="btn btn-light">
            </form>

        </div>
    </footer>

</html>
