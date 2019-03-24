
package Model;

import Data.OrderMapper;
import Data.UserMapper;
import java.util.ArrayList;

/**
 *
 * @author jojus1101
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginException {
        User user = new User( email, password, "customer" );
        UserMapper.createUser( user );
        return user;
    }
    
    public static Order createOrder( int length, int width, int height, int userid ) throws LoginException, InputException {
        Order order = new Order( length, width, height );
        OrderMapper.createOrder( order, userid );
        return order;
    }
    
    public static void updateIsSent( int orderid ) throws LoginException {
        OrderMapper.setShippingByOrderID( orderid );
    }
    
    public static ArrayList<Order> getOrdersByUserID( int userid ) throws LoginException {
        return OrderMapper.getOrdersByUserID( userid );
    }
    
    public static ArrayList<Order> getAllOrdersByShipping() throws LoginException {
        return OrderMapper.getAllOrdersByShipping();
    }
        
    public static Order getOrderByOrderID( int orderid ) throws LoginException {
        return OrderMapper.getOrderByOrderID( orderid );
    }
    
    public static Bricks calculateBricks( User user, int id ) throws LoginException {
        Order order = OrderMapper.getOrderByOrderID(id);
        House hc = new House();
        return hc.makeHouse( order.getLength(), order.getWidth(), order.getHeight() );
    }
}
