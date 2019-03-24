
package Presentation;

import Model.LoginException;
import Model.LogicFacade;
import Model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jojus1101
 */
public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginException {
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        if ( password1.equals(password2) ) {
            User user = LogicFacade.createUser( email, password1 );
            HttpSession session = request.getSession();
            session.setAttribute( "user", user );
            session.setAttribute( "role", user.getRole() );
            return user.getRole() + "page";
        } else {
            throw new LoginException( "the two passwords did not match" );
        }
    }

}
