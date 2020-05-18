
<%--

@author Matti

--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/Includes/Header.inc"%>
<body>

<div class="container" align="center">

    <img src="Images/fogs.jpg" class="img-fluid">

<script>
    function disable() {
        document.getElementById("skråTag1").disabled=true;
        document.getElementById("skråTag2").disabled=true;
        document.getElementById("fladtag").disabled=false;
    }
    function enable() {
        document.getElementById("skråTag1").disabled=false;
        document.getElementById("skråTag2").disabled=false;
        document.getElementById("fladtag").disabled=true;
    }
    function disable2() {
        document.getElementById("skur1").disabled=true;
        document.getElementById("skur2").disabled=true;
        document.getElementById("skur3").disabled=true;
    }
    function enable2() {
        document.getElementById("skur1").disabled=false;
        document.getElementById("skur2").disabled=false;
        document.getElementById("skur3").disabled=false;
    }


</script>

<div class="container" align="center">

    <h1 class="display-1 text-white">Carport</h1>

    <br>
    <h2 class="display-4 text-white">Byg din Carport</h2>
    <br>
    <form name="form" action="FrontController" method="POST">
        <input type="hidden" name="taget" value="form">

        <div>
            <div class="row">
                <div class="col-4"></div>
                <div class="col-4">

            <div class="form-check-inline">
                <label class="form-check-label text-white">
                    <input type="radio" class="form-check-input" onclick="disable()" name="optradio">Fladt tag
                </label>
            </div>
            <div class="form-check-inline">
                <label class="form-check-label text-white">
                    <input type="radio" class="form-check-input" onclick="enable()" name="optradio">Tag med rejsning
                </label>
            </div>
                </div>
                <div class="col-4">
                    <div class="form-check-inline">
                        <label class="form-check-label text-white">
                            <input type="radio" class="form-check-input" onclick="enable2()" name="optradio">Redskabsrum
                        </label>
                    </div>

                    <div class="form-check-inline">
                        <label class="form-check-label text-white">
                            <input type="radio" class="form-check-input" onclick="disable2()" name="optradio">Intet redskabsrum
                        </label>
                    </div>
                </div>

        </div>
        <br>

            <div class="row">

                <div class="col-4">

                    <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Bredde</label>
                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="width">

<%--                        <option selected>Choose...</option>--%>
                        <option value="0">Vælg...</option>
                        <option value="240">240 cm</option>
                        <option value="270">270 cm</option>
                        <option value="300">300 cm</option>
                        <option value="330">330 cm</option>
                        <option value="360">360 cm</option>
                        <option value="390">390 cm</option>
                        <option value="420">420 cm</option>
                        <option value="450">450 cm</option>
                        <option value="480">480 cm</option>
                        <option value="510">510 cm</option>
                        <option value="540">540 cm</option>
                        <option value="570">570 cm</option>
                        <option value="600">600 cm</option>
                        <option value="630">630 cm</option>
                        <option value="660">660 cm</option>
                        <option value="690">690 cm</option>
                        <option value="720">720 cm</option>
                        <option value="750">750 cm</option>
                    </select>
                </div>
                <div class="col-4">
                    <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Længde</label>
                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="length">

<%--                        <option selected>Choose...</option>--%>
                        <option value="0">Vælg...</option>
                        <option value="240">240 cm</option>
                        <option value="270">270 cm</option>
                        <option value="300">300 cm</option>
                        <option value="330">330 cm</option>
                        <option value="360">360 cm</option>
                        <option value="390">390 cm</option>
                        <option value="420">420 cm</option>
                        <option value="450">450 cm</option>
                        <option value="480">480 cm</option>
                        <option value="510">510 cm</option>
                        <option value="540">540 cm</option>
                        <option value="570">570 cm</option>
                        <option value="600">600 cm</option>
                        <option value="630">630 cm</option>
                        <option value="660">660 cm</option>
                        <option value="690">690 cm</option>
                        <option value="720">720 cm</option>
                        <option value="750">750 cm</option>
                    </select>
                </div>

                <div class="col-4">
                    <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Redskabsrum bredde</label>
                    <select id="skur1" class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="shedW">

<%--                        <option selected>Choose...</option>--%>
                        <option value="0">Vælg...</option>
                        <option value="1">Ønsker ikke</option>
                        <option value="210">210 cm</option>
                        <option value="240">240 cm</option>
                        <option value="270">270 cm</option>
                        <option value="300">300 cm</option>
                        <option value="330">330 cm</option>
                        <option value="360">360 cm</option>
                        <option value="390">390 cm</option>
                        <option value="420">420 cm</option>
                        <option value="450">450 cm</option>
                        <option value="480">480 cm</option>
                        <option value="510">510 cm</option>
                        <option value="540">540 cm</option>
                        <option value="570">570 cm</option>
                        <option value="600">600 cm</option>
                        <option value="630">630 cm</option>
                        <option value="660">660 cm</option>
                        <option value="690">690 cm</option>
                        <option value="720">720 cm</option>
                    </select>
                </div>



                <div class="col-4">
                    <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Tagmateriale - fladt tag</label>
                    <select disabled id="fladtag" class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="roofFMat">
<%--                        <option selected>Choose...</option>--%>
                        <option value="choose">Vælg...</option>
                        <c:forEach items="${requestScope.flatSet}" var="element">
                            <option value="${element}">${element}</option>
                        </c:forEach>
                        <!--<option value="Plasttrapezplader">Plasttrapezplader</option>
                        <option value="Tagpap">Tagpap</option>
                        <option value="Ståltag">Ståltag</option>-->
                    </select>
                </div>
                <div class="col-4">
                    <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Tagmateriale - tag med rejsning</label>
                    <select disabled id="skråTag1" class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="roofSMat">

<%--                        <option selected>Choose...</option>--%>
                        <option value="choose">Vælg...</option>
                        <c:forEach items="${requestScope.slopeRoofList}" var="element">
                            <option value="${element}">${element}</option>
                        </c:forEach>
                        <!--<option value="BetonTagsten1">Betontagsten - rød</option>
                        <option value="BetonTagsten2">Betontagsten - teglrød</option>
                        <option value="BetonTagsten3">Betontagsten - brun</option>
                        <option value="BetonTagsten4">Betontagsten - sort</option>
                        <option value="Eternittag1">Eternittag - b6 grå</option>
                        <option value="Eternittag2">Eternittag - b6 sort</option>
                        <option value="Eternittag3">Eternittag - b6 mokka</option>
                        <option value="Eternittag4">Eternittag - b6 rødbrun</option>
                        <option value="Eternittag5">Eternittag - b6 teglrød</option>
                        <option value="Eternittag6">Eternittag - b7 grå</option>
                        <option value="Eternittag7">Eternittag - b7 sort</option>
                        <option value="Eternittag8">Eternittag - b7 mokka</option>
                        <option value="Eternittag9">Eternittag - b7 rødbrun</option>
                        <option value="Eternittag10">Eternittag - b7 teglrød</option>
                        <option value="Eternittag11">Eternittag - b7 rødflammet</option>-->

                    </select>
                </div>
                <div class="col-4">
                    <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Redskabsrum længde</label>
                    <select id="skur2" class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="shedL">

                        <%--                        <option selected>Choose...</option>--%>
                        <option value="0">Vælg...</option>
                        <option value="1">Ønsker ikke</option>
                        <option value="150">150 cm</option>
                        <option value="180">180 cm</option>
                        <option value="210">210 cm</option>
                        <option value="240">240 cm</option>
                        <option value="270">270 cm</option>
                        <option value="300">300 cm</option>
                        <option value="330">330 cm</option>
                        <option value="360">360 cm</option>
                        <option value="390">390 cm</option>
                        <option value="420">420 cm</option>
                        <option value="450">450 cm</option>
                        <option value="480">480 cm</option>
                        <option value="510">510 cm</option>
                        <option value="540">540 cm</option>
                        <option value="570">570 cm</option>
                        <option value="600">600 cm</option>
                        <option value="630">630 cm</option>
                        <option value="660">660 cm</option>
                        <option value="690">690 cm</option>
                        <option value="720">720 cm</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-4"></div>
        <div class="col-4">
            <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Hældning</label>
            <select disabled id="skråTag2" class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="slope">

                <option value="0">Vælg...</option>
                <option value="15">15 grader</option>
                <option value="20">20 grader</option>
                <option value="25">25 grader</option>
                <option value="30">30 grader</option>
                <option value="35">35 grader</option>
                <option value="40">40 grader</option>
                <option value="45">45 grader</option>

            </select>
        </div>

        <div class="col-4">
            <label class="mr-sm-2 text-white" for="skur3">Redskabsrum beklædning</label>
            <select id="skur3" class="custom-select mr-sm-2" name="cladding">

                <option value="choose">Vælg...</option>
                <option value="Ingen">Ønsker ikke</option>
                <option value="Trykimpr">Trykimprægneret</option>
            </select>
        </div>
        </div>

        <br><br>


        <h2 class="text-white">Personlig Information</h2>
        <br>
        <div class="row">

            <div class="col-4">
                <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Navn</label>
                <div class="form-group">
                    <label for="Navn"></label>
                </div>

                <input type="text" name="Navn" class="form-control" placeholder="Navn" id="Navn">
            </div>


            <div class="col-4">
                <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Email</label>
                <div class="form-group">
                    <label for="email"></label>

                    <input type="email" name="Email" class="form-control" placeholder="Email" id="Email">
                </div>
            </div>

            <div class="col-4">
                <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Alder</label>
                <div class="form-group">
                    <label for="Alder"></label>
                </div>

                <input type="text" name="Alder" class="form-control" placeholder="Alder" id="Alder">
            </div>


            <div class="col-4">

                <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Adresse</label>
                <div class="form-group">
                    <label for="Adresse"></label>
                    <input type="text" name="Adresse" class="form-control" placeholder="Adresse" id="Adresse">
                </div>
            </div>

            <div class="col-4">
                <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">By</label>
                <div class="form-group">
                    <label for="By"></label>
                </div>

                <input type="text" name="by" class="form-control" placeholder="by" id="by">
            </div>


            <div class="col-4">

                <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Post NR</label>
                <div class="form-group">
                    <label for="PostNR"></label>
                    <input type="number" name="postNR" class="form-control" placeholder="postNR" id="postNR" min="1000" max="9999">
                </div>

            </div>

            <div class="col-4">

                <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Husnummer</label>
                <div class="form-group">
                    <label for="husnummer"></label>
                    <input type="text" name="husnummer" class="form-control" placeholder="husnummer" id="husnummer">
                </div>

            </div>
            <div class="col-4">

                <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Telefon</label>
                <div class="form-group">
                    <label for="telefon"></label>
                    <input type="number" name="telefon" class="form-control" placeholder="telefon" id="telefon" min="00000001" max="99999999">
                </div>

            </div>
        </div>
        <br><br>
        <input type="submit" value="Send anmodning" class="btn btn-primary btn-lg">


<div class="container" align="center">
    <c:if test = "${requestScope.error!= null}" >

        <h2>Error ! </h2>
        ${requestScope.error}

    </c:if>
</div>



    </form>
</div>
</div>

</body>
<%@include file="/Includes/Footer.inc"%>