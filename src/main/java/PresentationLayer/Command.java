package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "form", new Form() );
        commands.put( "tologin", new ToLogin() );
        commands.put( "sendRequest", new SendRequest());
        commands.put("getRequestList", new RequestListSorted() );
        commands.put("requestLists", new RequestLists());
        commands.put("newMaterialPage", new NewMaterial() );
        commands.put("toEmpPage", new Employeepage() );
        commands.put("CarportPortal", new CarportPortal());
        commands.put("addMaterial", new AddMaterial() );
        commands.put("getOnesRequests", new GetOnesRequests() );
        commands.put("review", new Review() );
        commands.put("svgdrawing", new Drawing() );

    }

    static Command from( HttpServletRequest request ) {
        String TagetName = request.getParameter( "taget" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(TagetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response )
            throws LoginSampleException;

}
