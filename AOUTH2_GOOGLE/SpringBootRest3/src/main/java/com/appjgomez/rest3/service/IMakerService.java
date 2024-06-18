/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.appjgomez.rest3.service;

import com.appjgomez.rest3.entities.Maker;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author JGomez
 */
public interface IMakerService {

    List<Maker> findAll();

    Optional<Maker> findById(Long id);

    void save(Maker maker);

    void deleteById(Long id);
}
