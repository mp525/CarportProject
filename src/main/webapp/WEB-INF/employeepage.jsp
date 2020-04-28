<%-- 
@Vibeke
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
            p {color: white; text-align: center;}
        </style>
    </head>
    <body>

    <div class="container" align="center">
        <img src="Images/fogs.jpg" class="img-fluid">

        <h1>Hej ${sessionScope.email} </h1>

        <p>Du er logget ind som ansat.</p>
    </div>


    <div style="text-align: center;display: block">
        <form name="requestLists" style="display: inline-block; margin-left: auto; margin-right: auto; text-align: left"
              action="FrontController" method="POST">
            <input type="hidden" name="taget" value="requestLists">
            <button type="submit" class="btn btn-primary">Gå til liste over alle anmodninger</button>
        </form>
    </div>



    <br><br>
    <div class="col" align="center">
        <form name="newMaterial" action="FrontController" method="POST">
            <input type="hidden" name="taget" value="newMaterialPage">
            <input type="submit" value="Tilføj nyt materiale til systemet" class="btn btn-light">
        </form>

    </div>

    </body>
</html>
