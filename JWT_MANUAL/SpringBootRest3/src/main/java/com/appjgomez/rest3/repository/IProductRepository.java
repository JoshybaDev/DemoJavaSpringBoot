/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appjgomez.rest3.repository;

import com.appjgomez.rest3.entities.Product;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JGomez
 */
@Repository
public interface IProductRepository extends CrudRepository<Product,Long>{
    List<Product>findProductByPriceBetween(BigDecimal minPrice,BigDecimal maxPrice);
    
    @Query("SELECT p from Product p where p.price between ?1 AND ?2")
    List<Product>findProductByPriceInRange(BigDecimal minPrice,BigDecimal maxPrice);    
}
