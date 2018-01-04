/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.hibernatewebapp1.netbeans.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arief
 */
public abstract class AbstractController extends HttpServlet{
    protected void forwardRequest(String jspFile , HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
        getServletContext()
                .getRequestDispatcher(jspFile+".jsp")
                .forward(request, response);
    }
    protected void redirectToContextPath(HttpServletResponse response) throws IOException{
        response.sendRedirect(getServletContext().getContextPath());
    }
}
