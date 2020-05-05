package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.StyklisteBeregner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarportPortal extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        System.out.println(StyklisteBeregner.antalSpær(750));

        return "Carport";
    }
}
