/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appjgomez.rest3.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.*;

/**
 *
 * @author JGomez
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Long Id;
    //@Column(name = "nombre")
    private String name;
    //@Column(name = "precio")
    private BigDecimal price;
    
    @ManyToOne
    @JoinColumn(name = "maker_id",nullable = false)
    @JsonIgnore
    private Maker maker;    
}
