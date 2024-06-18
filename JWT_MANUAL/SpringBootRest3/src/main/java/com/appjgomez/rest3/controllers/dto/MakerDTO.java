/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appjgomez.rest3.controllers.dto;

import com.appjgomez.rest3.entities.Product;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

/**
 *
 * @author JGomez
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakerDTO {//Data Transfer Object
    private Long id;
    private String name;
    private List<Product> productList = new ArrayList<>();
}
