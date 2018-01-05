package com.arief.hibernatewebapp1.netbeans.listeners;


import com.arief.hibernatewebapp1.netbeans.dao.CustomerDAO;
import com.arief.hibernatewebapp1.netbeans.dao.ProductCustomerDAO;
import com.arief.hibernatewebapp1.netbeans.dao.ProductDAO;
import com.arief.hibernatewebapp1.netbeans.dao.TransactionHistoryDAO;
import com.arief.hibernatewebapp1.netbeans.dao.impl.CustomerDAOImpl;
import com.arief.hibernatewebapp1.netbeans.dao.impl.ProductCustomerDAOImpl;
import com.arief.hibernatewebapp1.netbeans.dao.impl.ProductDAOImpl;
import com.arief.hibernatewebapp1.netbeans.dao.impl.TransactionHistoryDAOImpl;
import com.arief.hibernatewebapp1.netbeans.setup.HibernateSetup;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.hibernate.SessionFactory;



public class HibernateWebAppServletContextListener implements ServletContextListener{

    private SessionFactory sessionFactory; 
    private static final Logger LOGGER = Logger.
            getLogger(
                    HibernateWebAppServletContextListener.class.getName()
            );
    
//    private static final String CLASS_NAME = HibernateWebAppServletContextListener.class.getName();
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOGGER.log(Level.INFO,"contextInitialized ....");

        for(Map.Entry me :  sce.getServletContext().getServletRegistrations().entrySet()){
            LOGGER.log(Level.INFO,"Servlet_key  : " + me.getKey() + " Servlet_val : " + me.getValue());
        }
        
        
        LOGGER.log(Level.INFO,"sessionFactory initialized ....");
        sessionFactory = HibernateSetup.getSessionFactoryInstance();
        
        LOGGER.log(Level.INFO,"instantiate CustomerDAO ...");
        CustomerDAO customerDAO = new CustomerDAOImpl(sessionFactory);
        
        LOGGER.log(Level.INFO,"instantiate ProductCustomerDAO ...");
        ProductCustomerDAO productCustomerDAO = new ProductCustomerDAOImpl(sessionFactory);
        
        LOGGER.log(Level.INFO,"instantiate ProductDAO ...");
        ProductDAO productDAO = new ProductDAOImpl(sessionFactory);
        
        LOGGER.log(Level.INFO,"instantiate TransactionHistoryDAO ...");
        TransactionHistoryDAO transactionHistoryDAO = new TransactionHistoryDAOImpl(sessionFactory);
        
        
        LOGGER.log(Level.INFO,"injecting {customerDAO} bean into serlvetContext");
        sce.getServletContext()
                .setAttribute("customerDAO", customerDAO);
        
        LOGGER.log(Level.INFO,"injecting {productCustomerDAO} bean into servletContext");
        sce.getServletContext()
                .setAttribute("productCustomerDAO", productCustomerDAO);
        
        LOGGER.log(Level.INFO,"injecting {productDAO} bean into servletContext");
        sce.getServletContext()
                .setAttribute("productDAO", productDAO);
        
        LOGGER.log(Level.INFO,"injecting {transactionHistoryDAO} bean into servletContext");
        sce.getServletContext()
                .setAttribute("transactionHistoryDAO", transactionHistoryDAO);
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.log(Level.WARNING, "contextDestroyed ......");
        
        
        if(sessionFactory!=null){
            sessionFactory.close();            
            LOGGER.log(Level.INFO,"sessionFactory destroyed");
        }
    }
    
}
