package com.arief.hibernatewebapp1.netbeans.controllers.product.form;

import com.arief.hibernatewebapp1.netbeans.controllers.AbstractController;
import com.arief.hibernatewebapp1.netbeans.dao.ProductDAO;
import com.arief.hibernatewebapp1.netbeans.entity.Customer;
import com.arief.hibernatewebapp1.netbeans.entity.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arief
 */
@WebServlet(urlPatterns = {"/product/form"},name = "FormProductServlet")
public class FormProductController extends AbstractController{

    private final static Logger LOGGER = Logger.getLogger(FormProductController.class.getName());
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        

        String productId = req.getParameter("product_id");
        String productName = req.getParameter("product_name");
        float productPrice = Float.parseFloat(req.getParameter("product_price"));
        
        Product p = new Product();
        p.setCustomerList(new ArrayList<Customer>());
        p.setProductId(productId);
        p.setProductName(productName);
        p.setProductPrice(productPrice);
        
        ProductDAO productDAO = (ProductDAO)getServletContext().getAttribute("productDAO");
        
        productDAO.save(p);
        writePlainText(resp, "Save data {Product} OK");
    }
    
}
