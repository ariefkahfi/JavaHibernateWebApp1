/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.hibernatewebapp1.netbeans.test;

import com.arief.hibernatewebapp1.netbeans.dao.CustomerDAO;
import com.arief.hibernatewebapp1.netbeans.dao.ProductCustomerDAO;
import com.arief.hibernatewebapp1.netbeans.dao.ProductDAO;
import com.arief.hibernatewebapp1.netbeans.dao.TransactionHistoryDAO;
import com.arief.hibernatewebapp1.netbeans.dao.impl.CustomerDAOImpl;
import com.arief.hibernatewebapp1.netbeans.dao.impl.ProductCustomerDAOImpl;
import com.arief.hibernatewebapp1.netbeans.dao.impl.ProductDAOImpl;
import com.arief.hibernatewebapp1.netbeans.dao.impl.TransactionHistoryDAOImpl;
import com.arief.hibernatewebapp1.netbeans.entity.Customer;
import com.arief.hibernatewebapp1.netbeans.entity.Product;
import com.arief.hibernatewebapp1.netbeans.entity.TransactionHistory;
import com.arief.hibernatewebapp1.netbeans.setup.HibernateSetup;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.junit.Test;

/**
 *
 * @author arief
 */
public class HibernateWebAppTest {
    
    private static final  SessionFactory SESSION_FACTORY  = HibernateSetup.getSessionFactoryInstance();
    
//    @Test
//    public void testMethod()throws Exception{
//        SessionFactory sessionFactory = HibernateSetup.getSessionFactoryInstance();
//    }
    
    
    
        
    
//        @Test
        public void addProductToCustomer()throws Exception{
                
        }
        
        
//        @Test
        public void testBuyProduct()throws Exception{
            ProductCustomerDAO pcDAO = new ProductCustomerDAOImpl(SESSION_FACTORY);
            pcDAO.buyProduct("P003", "C001");
        }
//        @Test
        public void testCancelBuyProduct()throws Exception{
            ProductCustomerDAO pcDAO = new ProductCustomerDAOImpl(SESSION_FACTORY);
            pcDAO.cancelBuyProduct(4, "P003", "C001");
        }
        
//        @Test
        public void testFindTransactionHistoryByProductIdAndCustomerId()throws Exception{
            TransactionHistoryDAO tDAO = new TransactionHistoryDAOImpl(SESSION_FACTORY);
            TransactionHistory findOneByCustomerIdAndProductId = tDAO.findOneByCustomerIdAndProductId(1, "C001", "P001");
            
            System.out.println(findOneByCustomerIdAndProductId.toString());
        }
        
        
//        @Test
        public void testSaveTransactionHistory()throws Exception{
            
            CustomerDAO customerDAO = new CustomerDAOImpl(SESSION_FACTORY);
            ProductDAO productDAO = new ProductDAOImpl(SESSION_FACTORY);
            
            
            Customer c001 = customerDAO.findOne("C001");
            Product p001 = productDAO.findOne("P001");
            
            
            TransactionHistory tc = new TransactionHistory();
            tc.setCustomer(c001);
            tc.setProduct(p001);
            tc.setTransactionDate(new Date());
            tc.setTransactionItemName(p001.getProductName());
            
            
            
            TransactionHistoryDAO thDAO = new TransactionHistoryDAOImpl(SESSION_FACTORY);
            thDAO.save(tc);
            
            
        }
    
//      @Test
      public void testSaveProduct()throws Exception{
          SessionFactory sessionFactory = HibernateSetup.getSessionFactoryInstance();
          
          
          ProductDAO productDAO = new ProductDAOImpl(sessionFactory);
          CustomerDAO customerDAO = new CustomerDAOImpl(sessionFactory);
          
          Customer c1 = customerDAO.findOne("C001");
          Product laptop = productDAO.findOne("P001");
          
          c1.getProductList().add(laptop);
          
          customerDAO.update(c1);
          
          
      }
    
}
