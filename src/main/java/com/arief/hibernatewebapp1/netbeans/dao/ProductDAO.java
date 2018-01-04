/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.hibernatewebapp1.netbeans.dao;


import com.arief.hibernatewebapp1.netbeans.entity.Product;
import java.util.List;

/**
 *
 * @author arief
 */
public interface ProductDAO {
    public void save(Product c);
    public List<Product> findAll();
    public Product findOne(String productId);
    public void delete(Product c);
    public void update(Product c);
}
