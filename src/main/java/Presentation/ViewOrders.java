
package Presentation;
import Model.LoginException;
import Model.LogicFacade;
import Model.Order;
import Model.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jojus1101
 */
public class ViewOrders extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException {
        ArrayList<Order> ol = new ArrayList();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if ("customer".equals(user.getRole())) {
            ol = LogicFacade.getOrdersByUserID(user.getId());
            session.setAttribute("ordersByUserID", ol);
        } 
        else if ("employee".equals(user.getRole())) {
            ol = LogicFacade.getAllOrdersByShipping();
            session.setAttribute("getAllOrdersByShipping", ol);
        }
        return "vieworders";
    }
}
