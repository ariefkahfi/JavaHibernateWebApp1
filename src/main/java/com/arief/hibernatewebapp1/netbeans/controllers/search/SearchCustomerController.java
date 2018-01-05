package com.arief.hibernatewebapp1.netbeans.controllers.search;

import com.arief.hibernatewebapp1.netbeans.controllers.AbstractController;
import com.arief.hibernatewebapp1.netbeans.dao.CustomerDAO;
import com.arief.hibernatewebapp1.netbeans.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {
        "/search/customer"
},name = "SearchCustomerServlet")
public class SearchCustomerController extends AbstractController{

    private static final Logger LOGGER = Logger.getLogger(SearchCustomerController.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerId = req.getParameter("customer_id");

        CustomerDAO cDAO = (CustomerDAO)getServletContext().getAttribute("customerDAO");

        Customer c = cDAO.findOne(customerId);

        LOGGER.info("Customer c : " + c.toString());

        writePlainText(resp,"OK");

    }
}
