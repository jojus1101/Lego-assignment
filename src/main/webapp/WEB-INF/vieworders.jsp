<%-- 
    Document   : vieworders
    Created on : 24-03-2019, 19:42:19
    Author     : jojus1101
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Order"%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            User user = (User) session.getAttribute("user");
            if ("customers".equals(user.getRole())) {
        %>
        <table>
            <thead>
                <th>This is your previous orders</th>
            </thead>
            <tbody>
                <td>
                    <%
                        if (user != null) { 
                            ArrayList<Order> orderlist = new ArrayList<>();
                            orderlist = (ArrayList<Order>)request.getSession().getAttribute("ordersByUserID");
                            for (int i = 0; i < orderlist.size(); i++) { 
                            int orderID = orderlist.get(i).getId();
                    %>
                            <form action="FrontController" method="POST">
                                <input type="hidden" name="command" value="vieworder">
                                <input type="hidden" name="orderID" value="<%out.print(orderID);%>">
                                View order details concerning order ID: <%out.println(orderID);%><input type="submit" value="View order details">
                            </form>
                    <%
                            }
                        }
                    %>       
                </td>
            </tbody>
        </table>
        <%       
            } else if ("employee".equals(user.getRole())) {
        %>
        <table>
            <thead>
                <th>Click submit on an order to set order to shipped</th>
            </thead>
            <tr>
                <td>
                    <%
                        if (user != null) { 
                            ArrayList<Order> orderlist = new ArrayList<>();
                            orderlist = (ArrayList<Order>) session.getAttribute("getAllOrdersByShipping");
                            for (int i = 0; i < orderlist.size(); i++) { 
                            int orderID = orderlist.get(i).getId();
                    %>
                            <form action="FrontController" method="POST">
                                <input type="hidden" name="command" value="isSent">
                                <input type="hidden" name="orderID" value="<%out.print(orderID);%>">
                                    <% 
                                        if (orderlist.get(i).isIsSent() == false) { 
                                    %>
                                    Order ID: <%out.println(orderID);%><input type="submit" value="Mark as sent">
                                    <%
                                        }
                                    %>
                            </form>
                    <%
                            }
                        }
                    %>       
                </td>
            </tr>
        </table>
        <%
            }
        %>
         
    </body>
</html>
