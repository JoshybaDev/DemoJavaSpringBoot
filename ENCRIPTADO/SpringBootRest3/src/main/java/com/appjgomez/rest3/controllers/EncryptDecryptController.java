/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appjgomez.rest3.controllers;

import com.appjgomez.rest3.controllers.dto.EncryptDecryptDTO;
import com.appjgomez.rest3.security.EncryptDecrypt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JGomez
 */
@RestController
@RequestMapping("api/v1/security")
public class EncryptDecryptController {

    private final String key = "92AE31A79FEEB2A3"; //llave
    private final String vector = "0123456789ABCDEF"; // vector de inicialización

    @PostMapping("/encrypt")
    public ResponseEntity<?> encrypt(@RequestBody EncryptDecryptDTO encryptDecryptDTO) throws Exception {
        if(encryptDecryptDTO.getTextclear() == null){
            return ResponseEntity.badRequest().build();
        }
                if(encryptDecryptDTO.getTextclear().isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(EncryptDecrypt.encrypt(key, vector, encryptDecryptDTO.getTextclear()));
    }
    
    @PostMapping("/decrypt")
    public ResponseEntity<?> decrypt(@RequestBody EncryptDecryptDTO encryptDecryptDTO) throws Exception {
        if(encryptDecryptDTO.getTextencrypt() == null){
            return ResponseEntity.badRequest().build();
        }
                if(encryptDecryptDTO.getTextencrypt().isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(EncryptDecrypt.decrypt(key, vector, encryptDecryptDTO.getTextencrypt()));
    }    
}
