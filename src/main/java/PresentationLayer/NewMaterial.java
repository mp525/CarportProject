package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Mathias
 *
 * Denne klasse navigere brugeren til newmatpage.jsp
 *
 */


public class NewMaterial extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {



        return "newmatpage";
    }
}
