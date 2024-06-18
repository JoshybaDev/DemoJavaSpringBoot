/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appjgomez.rest3.persistance;

import com.appjgomez.rest3.entities.Product;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author JGomez
 */
public interface IProductDAO {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    void save(Product product);

    void deleteById(Long id);

    List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
}
