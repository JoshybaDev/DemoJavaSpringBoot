/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appjgomez.rest3.service.impl;

import com.appjgomez.rest3.entities.User;
import com.appjgomez.rest3.persistance.IUserDAO;
import com.appjgomez.rest3.service.IUserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JGomez
 */
@Service
public class UserServiceImpl implements IUserService {
    
    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }
    
    @Override
    public List<User> filter(String firstName, String lastName, String email) {
        return userDAO.filter(firstName, lastName, email);
    }   
}
