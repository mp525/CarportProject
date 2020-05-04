<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
@Vibeke
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <title>Form Review</title>
    <meta charset="utf-8">
    <style>
        body {background-color: #174986;}
        h1 {color: white; text-align: center;}
        /*p {color: white; text-align: center;}
        table {border: 1px solid white; border-collapse: collapse; width: 100%; text-align: center;}
        td {border: 1px solid white; border-collapse: collapse; width: 50%;}*/

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

<h1>Din bestilling</h1>

<%--<div class="container" align="center">
    <table>
        <tr>
            <td><p>Bredde:</p></td>
            <td><p>${requestScope.width} cm</p></td>
        </tr>
        <tr>
            <td><p>Længde:</p></td>
            <td><p>${requestScope.length} cm</p></td>
        </tr>
        &lt;%&ndash;<tr>
            <td><p>Tag:</p></td>
            <td><p>${requestScope.roof}</p></td>
        </tr>&ndash;%&gt;
        <tr>
            <td><p>Hældning:</p></td>
            <td><p>${requestScope.slope}</p></td>
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
</div>--%>

<%--<h1>Version 2:</h1>--%>

<div class="container" align="center">
    <table id="info">
        <tr>
            <td><p>Bredde:</p></td>
            <td><p>${requestScope.width} cm</p></td>
        </tr>
        <tr>
            <td><p>Længde:</p></td>
            <td><p>${requestScope.length} cm</p></td>
        </tr>
        <tr>
            <c:set var="roofFC" scope="session" value="${requestScope.roofF}"/>
            <c:choose>
                <c:when test="${roofFC == null}">

                </c:when>
                <c:when test="${roofFC == 'choose'}">

                </c:when>
                <c:otherwise>
                    <td><p>Tagmateriale - fladt tag:</p></td>
                    <td><p>${requestScope.roofF}</p></td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <c:set var="roofSC" scope="session" value="${requestScope.roofS}"/>
            <c:choose>
                <c:when test="${roofSC == null}">

                </c:when>
                <c:when test="${roofSC == 'choose'}">

                </c:when>
                <c:otherwise>
                    <td><p>Tagmateriale - skråt tag:</p></td>
                    <td><p>${requestScope.roofS}</p></td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <c:set var="slopeC" scope="session" value="${requestScope.slope}"/>
            <c:choose>
                <c:when test="${slopeC == null}">

                </c:when>
                <c:when test="${slopeC == 0}">

                </c:when>
                <c:otherwise>
                    <td><p>Hældning:</p></td>
                    <td><p>${requestScope.slope}</p></td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <c:set var="shedWC" scope="session" value="${requestScope.shedW}"/>
            <c:choose>
                <c:when test="${shedWC == null}"></c:when>
                <c:when test="${shedWC == '0'}">
                    <td><p>Redskabsrum bredde:</p></td>
                    <td><p>Ikke valgt endnu</p></td>
                </c:when>
                <c:when test="${shedWC == '1'}">
                    <td><p>Redskabsrum bredde:</p></td>
                    <td><p>Ønsker ikke</p></td>
                </c:when>
                <c:otherwise>
                    <td><p>Redskabsrum bredde:</p></td>
                    <td><p>${requestScope.shedW} cm</p></td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <c:set var="shedLC" scope="session" value="${requestScope.shedL}"/>
            <c:choose>
                <c:when test="${shedLC == null}"></c:when>
                <c:when test="${shedLC == '0'}">
                    <td><p>Redskabsrum længde:</p></td>
                    <td><p>Ikke valgt endnu</p></td>
                </c:when>
                <c:when test="${shedLC == 'Ingen'}">
                    <td><p>Redskabsrum længde:</p></td>
                    <td><p>Ønsker ikke</p></td>
                </c:when>
                <c:otherwise>
                    <td><p>Redskabsrum længde:</p></td>
                    <td><p>${requestScope.shedL} cm</p></td>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <c:set var="cladC" scope="session" value="${requestScope.cladding}"/>
            <c:choose>
                <c:when test="${cladC == null}"></c:when>
                <c:when test="${cladC == 'choose'}">
                    <td><p>Redskabsrum beklædning:</p></td>
                    <td><p>Ikke valgt endnu</p></td>
                </c:when>
                <c:when test="${cladC == 'Ingen'}">
                    <td><p>Redskabsrum beklædning:</p></td>
                    <td><p>Ønsker ikke</p></td>
                </c:when>
                <c:otherwise>
                    <td><p>Redskabsrum beklædning:</p></td>
                    <td><p>${requestScope.cladding}</p></td>
                </c:otherwise>
            </c:choose>
        </tr>
    </table>
</div>

<br>
<br>
<br>

<h1>Kontakt informationer</h1>

<div class="container" align="center">
    <table id="customer">
        <tr>
            <td><p>Navn: ${requestScope.name}</p></td>
        </tr>
        <tr>
            <td><p>Email: ${requestScope.email}</p></td>
        </tr>
        <tr>
            <td><p>Alder: ${requestScope.age}</p></td>
        </tr>
        <tr>
            <td><p>Adresse: ${requestScope.adr} ${requestScope.husnummer}</p></td>
        </tr>
        <tr>
            <td><p>By: ${requestScope.city}</p></td>
        </tr>
        <tr>
            <td><p>Postnummer: ${requestScope.zip}</p></td>
        </tr>
    </table>
</div>

<br>
<br>
<br>

<div style="text-align: center">
    <button type="button" class="btn btn-primary" name="back" onclick="history.back()">Tilføj ændring</button>
</div>

<%--<div style="text-align: center">
    <form name="index" action="FrontController" method="POST">
        <input type="hidden" name="taget" value="index">
        <button type="submit" class="btn btn-primary">Virker ikke</button>
    </form>
</div>--%>
<br>
<div class="col" align="center">
    <form name="form" action="FrontController" method="POST">
        <input type="hidden" name="taget" value="sendRequest">
        <input type="submit" class="btn btn-outline-success">
    </form>

</div>
<br>
<br>


</body>
</html>
