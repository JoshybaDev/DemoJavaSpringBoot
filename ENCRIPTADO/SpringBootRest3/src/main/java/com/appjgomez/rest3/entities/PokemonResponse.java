/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appjgomez.rest3.entities;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author JGomez
 */
@Setter
@Getter
public class PokemonResponse {
    private Long id;
    private Boolean is_default;
    private String location_area_encounters;
    private Object[] moves;
    private String name;
    private Long order;
    private Object[] past_abilities;
    private Object[] past_types;
    private Object species;
    private Object sprites;
    private Object[] stats;
    private Object[] types;
    private Long weight;    
}
