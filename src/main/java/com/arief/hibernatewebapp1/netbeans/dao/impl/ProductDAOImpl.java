/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.hibernatewebapp1.netbeans.dao.impl;

import com.arief.hibernatewebapp1.netbeans.dao.ProductDAO;
import com.arief.hibernatewebapp1.netbeans.entity.Product;
import com.arief.hibernatewebapp1.netbeans.transaction.HibernateInitializator;
import com.arief.hibernatewebapp1.netbeans.transaction.TransactionListener;
import com.arief.hibernatewebapp1.netbeans.transaction.TransactionManager;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author arief
 */
public class ProductDAOImpl implements ProductDAO{

    
    private final TransactionManager tManager;

    public ProductDAOImpl(SessionFactory sessionFactory) {
        this.tManager = new TransactionManager(sessionFactory);
    }
    
    
    
    
    
    @Override
    public void save(final Product c) {
       tManager.onSessionTransactionWithoutResult(new TransactionListener() {
           @Override
           public void onRunningTransactionWithOpenSession(Session s) {
               s.save(c);
           }
       });
    }

    @Override
    public List<Product> findAll() {
       List<Product> list = (List<Product>)tManager.onSessionTransactionWithListResult("from Product",new HibernateInitializator() {
           @Override
           public void initialize(Object o) {
               // not implemented yet
           }
       });
       return list;
    }

    @Override
    public Product findOne(String productId) {
        Product p = (Product)tManager.onSessionTransactionWithSingleResult(productId, Product.class,new HibernateInitializator() {
            @Override
            public void initialize(Object o) {
                // not implemented yet                
            }
        });
        return p;
    }

    @Override
    public void delete(final Product c) {
        tManager.onSessionTransactionWithoutResult(new TransactionListener() {
            @Override
            public void onRunningTransactionWithOpenSession(Session s) {
                s.delete(c);
            }
        });
    }

    @Override
    public void update(final Product c) {
        tManager.onSessionTransactionWithoutResult(new TransactionListener() {
            @Override
            public void onRunningTransactionWithOpenSession(Session s) {
                s.update(c);
            }
        });
    }


}
