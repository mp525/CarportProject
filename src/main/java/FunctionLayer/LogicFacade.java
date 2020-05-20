package FunctionLayer;

import DBAccess.UserMapper;

/**
 * The purpose of LogicFacade is to login
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 


}
