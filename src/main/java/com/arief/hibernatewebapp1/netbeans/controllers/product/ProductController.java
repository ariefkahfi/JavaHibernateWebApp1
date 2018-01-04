
package com.arief.hibernatewebapp1.netbeans.controllers.product;

import com.arief.hibernatewebapp1.netbeans.controllers.AbstractController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = {"/product"},name = "ProductServlet")
public class ProductController extends AbstractController{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardRequest("/WEB-INF/views/product/product", req, resp);
    }
    
}
