/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.hibernatewebapp1.netbeans.dao.impl;

import com.arief.hibernatewebapp1.netbeans.dao.CustomerDAO;
import com.arief.hibernatewebapp1.netbeans.entity.Customer;
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
public class CustomerDAOImpl implements CustomerDAO{

    
    
    private final TransactionManager tManager;

    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.tManager = new TransactionManager(sessionFactory);
    }

    @Override
    public void save(final Customer c) {
        tManager.onSessionTransactionWithoutResult(new TransactionListener() {
            @Override
            public void onRunningTransactionWithOpenSession(Session s) {
               s.save(c);
            }
        });
    }

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) tManager.onSessionTransactionWithListResult("from Customer", new HibernateInitializator() {
            @Override
            public void initialize(Object o) {
                
            }
        });
    }

    @Override
    public Customer findOne(String customerId) {
        return (Customer)tManager.onSessionTransactionWithSingleResult(customerId, Customer.class, new HibernateInitializator() {
            @Override
            public void initialize(Object o) {
                Customer getOne = (Customer)o;
                Hibernate.initialize(getOne.getProductList());
            }
        });
    }

    @Override
    public void delete(final Customer c) {
        tManager.onSessionTransactionWithoutResult(new TransactionListener() {
            @Override
            public void onRunningTransactionWithOpenSession(Session s) {
                s.delete(c);
            }
        });
    }

    @Override
    public void update(final Customer c) {
        tManager.onSessionTransactionWithoutResult(new TransactionListener() {
            @Override
            public void onRunningTransactionWithOpenSession(Session s) {
                s.update(c);
            }
        });
    }
    
    
    
    
    
    
    
}
