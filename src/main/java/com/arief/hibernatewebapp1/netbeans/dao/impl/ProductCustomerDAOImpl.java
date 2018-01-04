/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.hibernatewebapp1.netbeans.dao.impl;

import com.arief.hibernatewebapp1.netbeans.dao.CustomerDAO;
import com.arief.hibernatewebapp1.netbeans.dao.ProductCustomerDAO;
import com.arief.hibernatewebapp1.netbeans.dao.ProductDAO;
import com.arief.hibernatewebapp1.netbeans.dao.TransactionHistoryDAO;
import com.arief.hibernatewebapp1.netbeans.entity.Customer;
import com.arief.hibernatewebapp1.netbeans.entity.Product;
import com.arief.hibernatewebapp1.netbeans.entity.TransactionHistory;
import com.arief.hibernatewebapp1.netbeans.transaction.TransactionListener;
import com.arief.hibernatewebapp1.netbeans.transaction.TransactionManager;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author arief
 */
public class ProductCustomerDAOImpl implements ProductCustomerDAO{

    
    private final ProductDAO productDAO;
    private final CustomerDAO customerDAO;
    private final TransactionHistoryDAO transactionHistoryDAO; 
    private final TransactionManager tManager;
    
    
    public ProductCustomerDAOImpl(SessionFactory sessionFactory) {
        this.productDAO = new ProductDAOImpl(sessionFactory);
        this.customerDAO = new CustomerDAOImpl(sessionFactory);
        this.transactionHistoryDAO = new TransactionHistoryDAOImpl(sessionFactory);
        this.tManager = new TransactionManager(sessionFactory);
    }
    
    
    
    @Override
    public void buyProduct(String productId, String customerId) {
        Product p = productDAO.findOne(productId);
        Customer c  = customerDAO.findOne(customerId);
        
        
        boolean isExists = false;
        
        for(Product pp : c.getProductList()){
            if(pp.getProductId().equals(p.getProductId())){
                isExists = true;
                break;
            }
        }
        
        if(!isExists){
            c.getProductList().add(p);

            customerDAO.update(c);

            TransactionHistory transactionHistory = new TransactionHistory();

            transactionHistory.setCustomer(c);
            transactionHistory.setProduct(p);
            transactionHistory.setTransactionDate(new Date());
            transactionHistory.setTransactionItemName(p.getProductName());


            transactionHistoryDAO.save(transactionHistory);            
        }else{
            System.out.println("DATA EXISTS");
        }
        

        
    }

    @Override
    public void cancelBuyProduct(int transactionId, final String productId, final String customerId) {
        tManager.onSessionTransactionWithoutResult(new TransactionListener() {
            @Override
            public void onRunningTransactionWithOpenSession(Session s) {
                s.createNativeQuery("delete from product_customer "
                        + " where customer_id = :c_id "
                        + " and product_id = :p_id")
                        .setParameter("c_id", customerId)
                        .setParameter("p_id", productId)
                        .executeUpdate();
            }
        });
        TransactionHistory tc = transactionHistoryDAO.findOneByCustomerIdAndProductId(transactionId, customerId, productId);
        
        transactionHistoryDAO.delete(tc);
        
        
    }
    
}
