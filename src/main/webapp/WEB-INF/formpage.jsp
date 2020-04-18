<%--
@Vibeke
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <title>Form Page</title>
    <meta charset="utf-8">
    <style>
        body {background-color: #174986;}
        h1 {color: white; text-align: center}
        p {color: white; text-align: center}
    </style>
</head>
<body>

<h1>Din bestilling</h1>

<p>Bredde: ${requestScope.bot}</p>
<p>Længde: </p>
<p>Redskabsrum bredde: </p>
<p>Redskabsrum længde: </p>
<p>Tagmateriale - fladt tag: </p>
<p>Tagmateriale - skråt tag: </p>
<p>Hældning: </p>

<div style="text-align: center">
    <p>Test 1:</p>
    <button type="button" class="btn btn-primary" name="back" onclick="history.back()">Tilføj ændring</button>
</div>

<%--<div style="text-align: center">
    <form name="index" action="FrontController" method="POST">
        <input type="hidden" name="taget" value="index">
        <button type="submit" class="btn btn-primary">Virker ikke</button>
    </form>
</div>--%>

</body>
</html>
