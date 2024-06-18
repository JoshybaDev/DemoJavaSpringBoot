/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appjgomez.rest3.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JGomez
 */
@RestController
@RequestMapping("/api/v1")
public class HomeController {
    @GetMapping("/home")
        public ResponseEntity<?> home(){
        return ResponseEntity.ok("Bienvenido a Usuarios Demo");
    }
}