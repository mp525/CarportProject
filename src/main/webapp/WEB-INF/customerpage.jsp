<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../Includes/Header.inc"%>

<h1 class="text-white">Carporte</h1>
<h1>Hello ${sessionScope.email} </h1>
<br>
<form name="order" action="FrontController" method="POST">
    <input type="hidden" name="taget" value="order">
    <div class="shadow p-3 mb-5 bg-darkblue rounded">
        <div class="col-4">
            <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Size</label>
            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="bot">

                <option selected>Choose...</option>
                <option value="240">240</option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
            </select>
        </div>
        <div class="col-4">
            <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Bredde</label>
            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="top">

                <option selected>Choose...</option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
            </select>
        </div>
        <div class="col-4">
            <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Længde</label>
            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="top">

                <option selected>Choose...</option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
            </select>
        </div>
        <div class="col-4">
            <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Tag</label>
            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="top">

                <option selected>Choose...</option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
            </select>
        </div>
        <br>
        <div class="col-4">
            <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Tag</label>
            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="Hældning Eller Fladt Tag">

                <option selected>Choose...</option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
            </select>
        </div>
        <br>
        <div class="col-4">
            <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Redskabsrum bredde</label>
            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="top">

                <option selected>Choose...</option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
            </select>
        </div>
        <div class="col-4">
            <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Redskabsrum Længde</label>
            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="top">

                <option selected>Choose...</option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
            </select>
        </div>
        <br>
        <div class="col-4">
            <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Navn</label>
            <div class="form-group">
                <label for="Antal"></label>


                <input type="text" name="amount" class="form-control" placeholder="Navn" id="Antal">
            </div>
            <div class="col-4">
            </div>
            <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Email</label>
            <div class="form-group">
                <label for="Antal"></label>


                <input type="email" name="amount" class="form-control" placeholder="Email" id="Email">
            </div>
            <div class="col-4">
                <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Alder</label>
                <div class="form-group">
                    <label for="Antal"></label>
                </div>
            </div>
            <input type="text" name="amount" class="form-control" placeholder="Alder" id="Alder">

            <div class="col-4">
            </div>

            <label class="mr-sm-2 text-white" for="inlineFormCustomSelect">Adresse</label>
            <div class="form-group">
                <label for="Antal"></label>


                <input type="email" name="amount" class="form-control" placeholder="Adresse" id="Adresse">
            </div>
            <br><br>
            <input type="submit" value="Send anmodning" class="btn btn-primary btn-lg">

        </div>
    </div>

</form>

</body>
</html>
