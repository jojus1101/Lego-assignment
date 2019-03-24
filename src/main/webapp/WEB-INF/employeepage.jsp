<%-- 
    Document   : Employeepage
    Created on : 24-03-2019, 19:42:19
    Author     : jojus1101
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="vieworders">
            <input type="submit" value="Go to full orderlist">
        </form>
    </body>
</html>
