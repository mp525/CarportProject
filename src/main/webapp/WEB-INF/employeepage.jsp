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

        <p>Du er logget ind som Ansat.</p>
    </div>

    </body>
</html>
