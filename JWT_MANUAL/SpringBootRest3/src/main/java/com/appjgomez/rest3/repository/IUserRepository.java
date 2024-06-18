/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appjgomez.rest3.repository;

import com.appjgomez.rest3.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JGomez
 */
@Repository
public interface IUserRepository extends CrudRepository<User, Long> {

    public User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.firstName LIKE CONCAT('%',:first,'%') AND u.lastName LIKE CONCAT('%',:last,'%') AND u.email LIKE CONCAT('%',:email,'%')")
    List<User> filter(@Param("first") String firstName, @Param("last") String lastName, @Param("email") String email);
}
