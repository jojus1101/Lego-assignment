
package Presentation;

import Model.InputException;
import Model.LoginException;
import Model.Order;
import Model.LogicFacade;
import Model.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jojus1101
 */
public class MakeOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws InputException, LoginException {
        ArrayList<Order> ol = new ArrayList();
        HttpSession session = request.getSession();
        int length = Integer.parseInt( request.getParameter("length") );
        int width = Integer.parseInt( request.getParameter("width") );
        int height = Integer.parseInt( request.getParameter("height") );
        if ( length > 0 && width > 0 && height > 0 ) {
            User user = ( User ) request.getSession().getAttribute( "user" );
            ol = LogicFacade.getOrdersByUserID( user.getId() );
            LogicFacade.createOrder( length, width, height, user.getId() );
            session.setAttribute( "ordersByUserID", ol );
        } else {
            throw new InputException( "Some of the inputs are either empty or below 1" );
        }
        return "vieworders";
    }
}
