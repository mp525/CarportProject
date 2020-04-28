<%--
  Created by IntelliJ IDEA.
  User: Mathias
  Date: 27-04-2020
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tilføj nyt materiale</title>
    <style>
        body {background-color: #174986;}
        h1 {color: white; text-align: center;}
        p {color: white; text-align: center;}
    </style>
</head>
<body>

<div class="container" align="center">
    <img src="Images/fogs.jpg" class="img-fluid">
    <h1>Tilføj et nyt materiale til systemet</h1>

    <form name="employeepage" action="FrontController" method="POST">
        <input type="hidden" name="taget" value="addMaterial">

        <div class="col-3">
            <label class="mr-sm-2 text-white" for="kategori">Vælg kategori</label>
            <select class="custom-select mr-sm-2" id="kategori" name="kategori">

                <option value="choose">Vælg...</option>
                <option value="Træ">Træ</option>
                <option value="TagF">Tagmateriale - fladt tag</option>
                <option value="TagS">Tagmateriale - med rejsning</option>
                <option value="BeslagSkruer">Beslag og skruer</option>
            </select>
        </div>
    <br>

    <div class="row">

        <div class="col-3">
            <!--<label class="mr-sm-2 text-white">Materialets navn</label>
            <div class="form-group">
                <label for="matNavn"></label>
            </div>-->
            <p>Materialets navn</p>

            <input type="text" name="matNavn" class="form-control" placeholder="Navn" id="matNavn">
        </div>

        <div class="col-3">
            <!--<label class="mr-sm-2 text-white">Materialets længde</label>
            <div class="form-group">
                <label for="matLængde"></label>
            </div>-->
            <p>Materialets længde</p>

            <input type="text" name="matLængde" class="form-control" placeholder="Længde" id="matLængde">
        </div>

        <div class="col-3">
            <!--<label class="mr-sm-2 text-white">Enhed</label>
            <div class="form-group">
                <label for="enhed"></label>
            </div>-->
            <p>Enhed</p>

            <input type="text" name="enhed" class="form-control" placeholder="Enhed" id="enhed">
        </div>

        <div class="col-3">
            <!--<label class="mr-sm-2 text-white">Beskrivelse</label>
            <div class="form-group">
                <label for="beskrivelse"></label>
            </div>-->
            <p>Beskrivelse</p>

            <input type="text" name="beskrivelse" class="form-control" placeholder="Beskrivelse" id="beskrivelse">
        </div>

    </div>
        <br>
        <p>${requestScope.besked}</p>
        <br>
        <input type="submit" value="Tilføj" class="btn btn-outline-success">
</form>
</div>

<br><br>
<div class="col" align="center">
    <form name="employeepage" action="FrontController" method="POST">
        <input type="hidden" name="taget" value="toEmpPage">
        <input type="submit" value="Tilbage" class="btn btn-light">
    </form>

</div>
<br><br>
</body>
</html>
