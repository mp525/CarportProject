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
