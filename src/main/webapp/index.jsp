<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/Includes/Header.inc"%>

    <h1 class="text-white">Carport</h1>

    <br>
    <h2 class="text-white">Customize your Carport</h2>
    <br>
    <form name="order" action="FrontController" method="POST">
        <input type="hidden" name="taget" value="order">

        <div>

            <div class="form-check-inline">
                <label class="form-check-label text-white">
                    <input type="radio" class="form-check-input" onclick="disable()" name="optradio">Fladt tag
                </label>
            </div>
            <div class="form-check-inline">
                <label class="form-check-label text-white">
                    <input type="radio" class="form-check-input" onclick="enable()" name="optradio">Skråt tag
                </label>
            </div>
            <br><br>


            <div class="row">

                <div class="col-4">

                    <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Bredde</label>
                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="bot">

                        <option selected>Choose...</option>
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
                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="top">

                        <option selected>Choose...</option>
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
                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="top">

                        <option selected>Choose...</option>
                        <option value="Ingen">Ønsker ikke</option>
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
                    <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Redskabsrum Længde</label>
                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="top">

                        <option selected>Choose...</option>
                        <option value="Ingen">Ønsker ikke</option>
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


                <div class="col-4">
                    <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Tagmateriale - fladt tag</label>
                    <select id="fladtag" class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="top">
                        <option selected>Choose...</option>
                        <option value="Plasttrapezplader">Plasttrapezplader</option>
                    </select>
                </div>
                <div class="col-4">
                    <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Tagmateriale - skråt tag</label>
                    <select id="skråTag1" class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="top">

                        <option selected>Choose...</option>
                        <option value="BetonTagsten1">Betontagsten - rød</option>
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
                        <option value="Eternittag11">Eternittag - b7 rødflammet</option>

                    </select>
                </div>
            </div>
        </div>
        <div class="col-4">
            <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Hældning</label>
            <select id="skråTag2" class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="Hældning Eller Fladt Tag">

                <option selected>Choose...</option>
                <!--<option value="Fladt tag">Fladt tag</option>-->
                <option value="15 grader">15 grader</option>
                <option value="20 grader">20 grader</option>
                <option value="25 grader">25 grader</option>
                <option value="30 grader">30 grader</option>
                <option value="35 grader">35 grader</option>
                <option value="40 grader">40 grader</option>
                <option value="45 grader">45 grader</option>

            </select>
        </div>





        <br><br>


        <h2 class="text-white">Personal Information</h2>
        <br>
        <div class="row">

            <div class="col-4">
                <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Navn</label>
                <div class="form-group">
                    <label for="Navn"></label>
                </div>

                <input type="text" name="amount" class="form-control" placeholder="Navn" id="Antal">
            </div>


            <div class="col-4">
                <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Email</label>
                <div class="form-group">
                    <label for="email"></label>

                    <input type="email" name="amount" class="form-control" placeholder="Email" id="Email">
                </div>
            </div>

            <div class="col-4">
                <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Alder</label>
                <div class="form-group">
                    <label for="Alder"></label>
                </div>

                <input type="text" name="amount" class="form-control" placeholder="Alder" id="Alder">
            </div>


            <div class="col-4">

                <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Adresse</label>
                <div class="form-group">
                    <label for="Adresse"></label>
                    <input type="email" name="amount" class="form-control" placeholder="Adresse" id="Adresse">
                </div>
            </div>

            <div class="col-4">
                <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">By</label>
                <div class="form-group">
                    <label for="By"></label>
                </div>

                <input type="text" name="amount" class="form-control" placeholder="Alder" id="Alder">
            </div>


            <div class="col-4">

                <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Post NR</label>
                <div class="form-group">
                    <label for="PostNR"></label>
                    <input type="number" name="amount" class="form-control" placeholder="Adresse" id="Adresse">
                </div>

            </div>
        </div>
        <br><br>
        <input type="submit" value="Send anmodning" class="btn btn-primary btn-lg">






    </form>
</div>
</body>
</html>