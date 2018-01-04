/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.hibernatewebapp1.netbeans.dao.impl;

import com.arief.hibernatewebapp1.netbeans.dao.TransactionHistoryDAO;
import com.arief.hibernatewebapp1.netbeans.entity.TransactionHistory;
import com.arief.hibernatewebapp1.netbeans.transaction.HibernateInitializator;
import com.arief.hibernatewebapp1.netbeans.transaction.TransactionListener;
import com.arief.hibernatewebapp1.netbeans.transaction.TransactionManager;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

/**
 *
 * @author arief
 */
public class TransactionHistoryDAOImpl implements TransactionHistoryDAO{

    
    private final TransactionManager tManager;
    private TransactionHistory transactionHistory;
    
    public TransactionHistoryDAOImpl(SessionFactory sessionFactory) {
        this.tManager = new TransactionManager(sessionFactory);
    }

    private void setTransactionHistory(TransactionHistory transactionHistory){
        this.transactionHistory=transactionHistory;
    }
    
    @Override
    public TransactionHistory findOneByCustomerIdAndProductId(final int transactionId , final String custId, final String productId) {
        tManager.onSessionTransactionWithoutResult(new TransactionListener() {
            @Override
            public void onRunningTransactionWithOpenSession(Session s) {
                NativeQuery<TransactionHistory> createQuery = s.createNativeQuery(
                        "select * from transaction_history where "
                        + " transaction_id = :t_id and "
                        + " transaction_customer_id = :c_id and "
                        + " product_id = :p_id" )
                        .setParameter("t_id", transactionId)
                        .setParameter("c_id", custId)
                        .setParameter("p_id", productId)
                        .addEntity(TransactionHistory.class);
                TransactionHistory singleResult =  createQuery.getSingleResult();
                setTransactionHistory(singleResult);
            }
        });
        return this.transactionHistory;
    }
    
    
    
    
    @Override
    public void save(final TransactionHistory c) {
        tManager.onSessionTransactionWithoutResult(new TransactionListener() {
            @Override
            public void onRunningTransactionWithOpenSession(Session s) {
                s.save(c);
            }
        });
    }

    @Override
    public List<TransactionHistory> findAll() {
        return (List<TransactionHistory>)tManager.onSessionTransactionWithListResult("from TransactionHistory", new HibernateInitializator() {
            @Override
            public void initialize(Object o) {
                
            }
        });
    }

    @Override
    public TransactionHistory findOne(int transactionId) {
        return (TransactionHistory)tManager
                .onSessionTransactionWithSingleResult(transactionId, TransactionHistory.class, 
                        new HibernateInitializator() {
                @Override
                public void initialize(Object o) {
                 
                }
        });
    }

    @Override
    public void delete(final TransactionHistory c) {
        tManager.onSessionTransactionWithoutResult(new TransactionListener() {
            @Override
            public void onRunningTransactionWithOpenSession(Session s) {
                s.delete(c);
            }
        });
    }

    @Override
    public void update(final TransactionHistory c) {
        tManager.onSessionTransactionWithoutResult(new TransactionListener() {
            @Override
            public void onRunningTransactionWithOpenSession(Session s) {
                s.update(c);
            }
        });
    }
    
}
