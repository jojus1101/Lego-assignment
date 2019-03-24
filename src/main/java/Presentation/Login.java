
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
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = LogicFacade.login(email, password);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            return user.getRole() + "page";
        } catch (Exception ex) {
            throw new LoginException( ex.getMessage() );
        }
    }

}

