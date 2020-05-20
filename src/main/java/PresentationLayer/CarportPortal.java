package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.StyklisteBeregner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Matti
 * Denne klasse bruges til at navigere til Carport.jsp
 *
 */

public class CarportPortal extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        return "Carport";
    }
}
