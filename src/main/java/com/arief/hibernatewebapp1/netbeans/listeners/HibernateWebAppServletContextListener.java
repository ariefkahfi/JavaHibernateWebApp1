package com.arief.hibernatewebapp1.netbeans.listeners;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



public class HibernateWebAppServletContextListener implements ServletContextListener{

    private static final Logger LOGGER = Logger.
            getLogger(
                    HibernateWebAppServletContextListener.class.getName()
            );
    
//    private static final String CLASS_NAME = HibernateWebAppServletContextListener.class.getName();
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOGGER.log(Level.INFO,"contextInitialized ....");
        
        
//        LOGGER.log(Level.INFO,"sessionFactory initialized ....");
        
        
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.log(Level.WARNING, "contextDestroyed ......");
    }
    
}
