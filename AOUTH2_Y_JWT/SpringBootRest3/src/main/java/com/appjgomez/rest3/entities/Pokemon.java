/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appjgomez.rest3.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author JGomez
 */
@Setter
@Getter
public class Pokemon {

    @JsonProperty
    private Object[] abilities;
    @JsonProperty
    private Long base_experience;
    @JsonProperty
    private Object cries;
    @JsonProperty
    private Object[] forms;
    @JsonProperty
    private Object[] game_indices;
    @JsonProperty
    private Long height;
    @JsonProperty
    private Object[] held_items;

    /* =========================================  */
    @JsonProperty
    private Long id;
    @JsonProperty
    private Boolean is_default;
    @JsonProperty
    private String location_area_encounters;
    @JsonProperty
    private Object[] moves;
    @JsonProperty
    private String name;
    @JsonProperty
    private Long order;
    @JsonProperty
    private Object[] past_abilities;
    @JsonProperty
    private Object[] past_types;
    @JsonProperty
    private Object species;
    @JsonProperty
    private Object sprites;
    @JsonProperty
    private Object[] stats;
    @JsonProperty
    private Object[] types;
    @JsonProperty
    private Long weight;
}
