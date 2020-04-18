package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Form extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        //        Width
        String bot = request.getParameter("bot");
        request.setAttribute("bot", bot);

        return "form" + "page";
    }
}
