/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.hibernatewebapp1.netbeans.dao;

import com.arief.hibernatewebapp1.netbeans.entity.Customer;
import java.util.List;

/**
 *
 * @author arief
 */
public interface CustomerDAO {
    public void save(Customer c);
    public List<Customer> findAll();
    public Customer findOne(String customerId);
    public void delete(Customer c);
    public void update(Customer c);
}
