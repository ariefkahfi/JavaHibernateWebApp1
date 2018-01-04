/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.hibernatewebapp1.netbeans.setup;

import com.arief.hibernatewebapp1.netbeans.entity.Customer;
import com.arief.hibernatewebapp1.netbeans.entity.Product;
import com.arief.hibernatewebapp1.netbeans.entity.TransactionHistory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author arief
 */
public class HibernateSetup {
    private static SessionFactory buildUpSessionFactory(){
        Configuration config  = new 
            Configuration()
                .setProperties(HibernateConfiguration.getHibernateProperties())
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(TransactionHistory.class);
        return config.buildSessionFactory();
    }
    
    public static SessionFactory getSessionFactoryInstance(){
        return buildUpSessionFactory();
    }
}
