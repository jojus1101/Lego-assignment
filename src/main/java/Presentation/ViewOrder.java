
package Presentation;

import Model.InputException;
import Model.LoginException;
import Model.Bricks;
import Model.LogicFacade;
import Model.Order;
import Model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jojus1101
 */
public class ViewOrder extends Command {
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if ("customer".equals(user.getRole())) {
            int orderid = Integer.parseInt(request.getParameter("orderID"));
            Order order = LogicFacade.getOrderByOrderID(orderid);
            Bricks b = LogicFacade.calculateBricks(user, orderid);
            session.setAttribute("order", order);
            session.setAttribute("orderID", orderid);
            session.setAttribute("bricks", b);
        } else {
            throw new LoginException("LOLOLOL");
        }
        return "vieworderdetails";
    }
}
