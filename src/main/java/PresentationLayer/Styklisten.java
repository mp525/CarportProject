package PresentationLayer;

import DBAccess.MaterialMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class Styklisten extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        /*MaterialMapper m = new MaterialMapper();
        ArrayList <String>descriptions =m.findmaterials();
        ArrayList <Material>stykliste= m.getMatsStykliste(descriptions);
        request.setAttribute("Stykliste", stykliste);
        */return null;
    }
}
