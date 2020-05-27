package FunctionLayer;

import DBAccess.UserMapper;

/**
 *
 * @author kasper
 * Denne klasse bruges til at logge en bruger ind.
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 


}
