package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author Vibeke
 *
 * Denne metode sender brugeren til loginpage.jsp
 *
 */
public class ToLogin extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        return "loginpage";
    }
}
