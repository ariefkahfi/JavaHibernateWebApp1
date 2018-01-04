package com.arief.hibernatewebapp1.netbeans.controllers.customer.form;

import com.arief.hibernatewebapp1.netbeans.controllers.AbstractController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/customer/form"},name = "FormCustomerServlet")
public class FormCustomerController extends AbstractController{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
    }
    
}
