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
        h1 {color: white; text-align: center;}
        p {color: white; text-align: center;}
        table {border: 1px solid white; border-collapse: collapse; width: 100%; text-align: center;}
        td {border: 1px solid white; border-collapse: collapse; width: 50%;}
    </style>
</head>
<body>

<div class="container" align="center">
    <img src="Images/fogs.jpg" class="img-fluid">
</div>

<h1>Din bestilling</h1>

<div class="container" align="center">
    <table>
        <tr>
            <td><p>Bredde:</p></td>
            <td><p>${requestScope.width} cm</p></td>
        </tr>
        <tr>
            <td><p>Længde:</p></td>
            <td><p>${requestScope.length} cm</p></td>
        </tr>
        <tr>
            <td><p>Tag:</p></td>
            <td><p>${requestScope.roof}</p></td>
        </tr>
        <tr>
            <td><p>Hældning:</p></td>
            <td><p>${requestScope.slope} grader</p></td>
        </tr>
        <tr>
            <td><p>Redskabsrum bredde:</p></td>
            <td><p>${requestScope.shedW} cm</p></td>
        </tr>
        <tr>
            <td><p>Redskabsrum længde:</p></td>
            <td><p>${requestScope.shedL} cm</p></td>
        </tr>
        <tr>
            <td><p>Tagmateriale - fladt tag:</p></td>
            <td><p>${requestScope.roofF}</p></td>
        </tr>
        <tr>
            <td><p>Tagmateriale - skråt tag:</p></td>
            <td><p>${requestScope.roofS}</p></td>
        </tr>
    </table>
</div>

<p>Bredde: ${requestScope.width} cm</p>
<p>Længde: ${requestScope.length} cm</p>
<p>Tag: ${requestScope.roof}</p>
<p>Hældning: ${requestScope.slope} grader</p>
<p>Redskabsrum bredde: ${requestScope.shedW} cm</p>
<p>Redskabsrum længde: ${requestScope.shedL} cm</p>
<p>Tagmateriale - fladt tag: ${requestScope.roofF}</p>
<p>Tagmateriale - skråt tag: ${requestScope.roofS}</p>
<p>Hældning: ??</p>

<div style="text-align: center">
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
