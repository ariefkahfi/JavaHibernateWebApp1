package com.arief.hibernatewebapp1.netbeans.controllers.customer.form;

import com.arief.hibernatewebapp1.netbeans.controllers.AbstractController;
import com.arief.hibernatewebapp1.netbeans.dao.CustomerDAO;
import com.arief.hibernatewebapp1.netbeans.entity.Customer;
import com.arief.hibernatewebapp1.netbeans.entity.Product;
import com.arief.hibernatewebapp1.netbeans.entity.TransactionHistory;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.logging.Logger;


public class FormCustomerController extends AbstractController {

    private static final Logger LOGGER = Logger.getLogger(FormCustomerController.class.getName());



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerId = req.getParameter("customer_id");
        String customerName = req.getParameter("customer_name");

        LOGGER.info("ID : " + customerId + " Name : " + customerName);
//          redirectToContextPath(resp);
//          resp.sendRedirect(getServletContext().getContextPath());

//        redirectToPath(resp, getServletContext().getContextPath()+"/customer");

        Customer c = new Customer();
        c.setCustomerId(customerId);
        c.setCustomerName(customerName);
        c.setProductList(new ArrayList<Product>());
        c.setTransactionHistoryList(new ArrayList<TransactionHistory>());

        CustomerDAO cDAO = (CustomerDAO)getServletContext().getAttribute("customerDAO");
        cDAO.save(c);
        writePlainText(resp,"Save Customer OK");
    }
    
}
