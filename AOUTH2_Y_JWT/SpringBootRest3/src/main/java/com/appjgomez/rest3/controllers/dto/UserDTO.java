/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appjgomez.rest3.controllers.dto;

import lombok.*;

/**
 *
 * @author JGomez
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {//Data Transfer Object

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
