
package com.arief.hibernatewebapp1.netbeans.controllers.customer;

import com.arief.hibernatewebapp1.netbeans.controllers.AbstractController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/customer"} , name = "CustomerServlet")
public class CustomerController extends AbstractController{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardRequest("/WEB-INF/views/customer/customer", req, resp);
    }
    
}
