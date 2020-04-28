package PresentationLayer;

import DBAccess.MaterialMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddMaterial extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String kategori = request.getParameter("kategori");
        String matnavn = request.getParameter("matNavn");
        String matlaengde = request.getParameter("matLaengde");
        //String matAntal = request.getParameter("matAntal");
        String enhed = request.getParameter("enhed");
        String beskrivelse = request.getParameter("beskrivelse");
        String pris = request.getParameter("pris");

        /*request.setAttribute("kategori", kategori);
        request.setAttribute("matNavn", matnavn);
        request.setAttribute("matlaengde", matlaengde);
        request.setAttribute("matAntal", matAntal);
        request.setAttribute("enhed", enhed);
        request.setAttribute("beskrivelse", beskrivelse);
        request.setAttribute("pris", pris);*/

        int length = Integer.parseInt(request.getParameter("matLaengde".trim()));
        //int amount = Integer.parseInt(request.getParameter("matAntal".trim()));
        double price = Double.parseDouble(request.getParameter("pris".trim()));

        Material mat = new Material(matnavn, beskrivelse, enhed, kategori, length, price);

        if (kategori.equals("TagFlat")){
            MaterialMapper.insertFlat(mat);
        } else if (kategori.equals("TagHaeld")){
            MaterialMapper.insertSlope(mat);
        } else if (kategori.equals("Beslag & Skruer") || kategori.equals("Trae") || kategori.equals("Trae og Tagplader")){
            MaterialMapper.insertMat(mat);
        }

        request.setAttribute("besked", matnavn + " blev tilføjet til databasen.");
        return "newmatpage";
    }
}
