/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.hibernatewebapp1.netbeans.dao;
/*
    session open
    tx begin

    Product p = productDAO.findOne("P001");

    Customer c = customerDAO.findOne("C001");


    c.getProductList().add(p);

    customerDAO.update(c);

    TransactionHistory th = new TransactionHistory();
    
    th.setItemName(p.getName());
    th.setTransactionDate(new Date());
    th.setCustomer(c);
    th.setProduct(p);

    transactionHistoryDAO.save(th);
    
    TransactionHistory findTh = thDAO.findOneByProductAndCustomer("P001","C002");

    thDAO.remove(findTh);
  



    tx commit
    session close
*/


/**
 *
 * @author arief
 */
public interface ProductCustomerDAO {
    public String buyProduct(String productId , String customerId);
    public void cancelBuyProduct(int transactionId , String productId , String customerId);
}
