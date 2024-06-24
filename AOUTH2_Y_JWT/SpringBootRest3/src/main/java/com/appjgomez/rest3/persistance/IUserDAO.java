/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appjgomez.rest3.persistance;

import com.appjgomez.rest3.entities.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author JGomez
 */
public interface IUserDAO {

    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    void deleteById(Long id); 
    
    List<User> filter(String firstName, String lastName, String email);
}
