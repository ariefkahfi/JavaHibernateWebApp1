/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.hibernatewebapp1.netbeans.dao;

import com.arief.hibernatewebapp1.netbeans.entity.TransactionHistory;
import java.util.List;

/**
 *
 * @author arief
 */
public interface TransactionHistoryDAO {
    public void save(TransactionHistory c);
    public List<TransactionHistory> findAll();
    public TransactionHistory findOne(int transactionId);
    public void delete(TransactionHistory c);
    public void update(TransactionHistory c);
    public TransactionHistory findOneByCustomerIdAndProductId(int transactionId, String custId,String productId);
}
