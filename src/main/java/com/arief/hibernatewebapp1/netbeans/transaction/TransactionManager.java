/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.hibernatewebapp1.netbeans.transaction;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.jboss.logging.Logger;

/**
 *
 * @author arief
 */
public class TransactionManager {
    
    
    private SessionFactory sessionFactory;
    private static final Logger LOGGER = Logger.getLogger(TransactionManager.class.getName());
    
    
    public TransactionManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    
    
    public Object onSessionTransactionWithSingleResult(
            Serializable id , 
            Class type,
            HibernateInitializator hibInit
    ){
        Session session = sessionFactory.openSession();
        Object o = null;
        try {
            session.beginTransaction();
            o = session.get(type, id);
            if(o!=null){
                hibInit.initialize(o);
            }
            session.getTransaction().commit();
            LOGGER.info("committed transaction ....");
        } catch (Exception e) {
            if(session.getTransaction()!=null)session.getTransaction().rollback();
            LOGGER.info("rollback transaction ....");
            e.printStackTrace();
        }finally{
            session.close();
            LOGGER.info("session close ....");
        }
        
        return o;
    }
    
    public Object onSessionTransactionWithListResult(
            String sqlQuery,
            HibernateInitializator hibInit
    ){
        Session session = sessionFactory.openSession();
        List<Object> objectList = null;
        try {
            session.beginTransaction();
            objectList = session.createQuery(sqlQuery).list();
            hibInit.initialize(objectList);
            session.getTransaction().commit();
            LOGGER.info("committed transaction ....");
        } catch (Exception e) {
            if(session.getTransaction()!=null)session.getTransaction().rollback();
            LOGGER.info("rollback transaction ....");
            e.printStackTrace();
        }finally{
            session.close();
            LOGGER.info("session close ....");
        }
        return objectList;
    }
    
    public void onSessionTransactionWithoutResult(TransactionListener transactionListener){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            transactionListener.onRunningTransactionWithOpenSession(session);
            session.getTransaction().commit();
            LOGGER.info("committed transaction ....");
        } catch (Exception e) {
            if(session.getTransaction()!=null)session.getTransaction().rollback();
            LOGGER.info("rollback transaction ....");
            e.printStackTrace();
        }finally{
            session.close();
            LOGGER.info("session close ....");
        }
    }
    
}
