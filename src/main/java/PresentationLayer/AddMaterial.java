package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddMaterial extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String kategori = request.getParameter("kategori");
        String matnavn = request.getParameter("matNavn");
        String matlaengde = request.getParameter("matLængde");
        String enhed = request.getParameter("enhed");
        String beskrivelse = request.getParameter("beskrivelse");


        request.setAttribute("besked", "Materialet blev tilføjet til databasen.");
        return "newmatpage";
    }
}
