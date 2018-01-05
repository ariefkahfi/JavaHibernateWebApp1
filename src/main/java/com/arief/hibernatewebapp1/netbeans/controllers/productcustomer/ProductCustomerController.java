package com.arief.hibernatewebapp1.netbeans.controllers.productcustomer;

import com.arief.hibernatewebapp1.netbeans.controllers.AbstractController;
import com.arief.hibernatewebapp1.netbeans.dao.ProductCustomerDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;


public class ProductCustomerController extends AbstractController{


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.getLogger(ProductCustomerController.class.getName()).info("incoming request from client ....");

        String customerId = req.getParameter("customer_id");
        String productId = req.getParameter("product_id");

        ProductCustomerDAO pcDAO = (ProductCustomerDAO)getServletContext().getAttribute("productCustomerDAO");
        String purchaseResponse = pcDAO.buyProduct(productId,customerId);

        writePlainText(resp,purchaseResponse);
    }
}
