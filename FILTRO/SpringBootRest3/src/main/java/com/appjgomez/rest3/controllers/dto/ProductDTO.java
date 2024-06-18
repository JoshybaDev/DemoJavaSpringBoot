/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appjgomez.rest3.controllers.dto;

import com.appjgomez.rest3.entities.Maker;
import java.math.BigDecimal;
import lombok.*;

/**
 *
 * @author JGomez
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private Maker maker;
}
