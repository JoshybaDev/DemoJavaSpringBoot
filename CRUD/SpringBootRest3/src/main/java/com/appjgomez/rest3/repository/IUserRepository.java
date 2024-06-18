/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appjgomez.rest3.repository;

import com.appjgomez.rest3.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JGomez
 */
@Repository
public interface IUserRepository extends CrudRepository<User,Long>{
    public User findByUsername(String username); 
}
