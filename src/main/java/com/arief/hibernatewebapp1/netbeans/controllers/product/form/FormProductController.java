package com.arief.hibernatewebapp1.netbeans.controllers.product.form;

import com.arief.hibernatewebapp1.netbeans.controllers.AbstractController;
import java.io.IOException;
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
}
