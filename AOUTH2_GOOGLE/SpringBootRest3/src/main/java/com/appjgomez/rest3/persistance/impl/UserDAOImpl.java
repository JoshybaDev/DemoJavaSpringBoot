/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appjgomez.rest3.persistance.impl;

import com.appjgomez.rest3.entities.User;
import com.appjgomez.rest3.persistance.IUserDAO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.appjgomez.rest3.repository.IUserRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author JGomez
 */
@Component
public class UserDAOImpl implements IUserDAO{
    
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> filter(String firstName, String lastName, String email) {
        return userRepository.filter(firstName, lastName, email);
    }
    
}
