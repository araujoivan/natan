/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Eder_Crespo
 */

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
       
    
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        
        final User userSaved = userService.save(user);
            
        return ResponseEntity.ok(userSaved);
        
    }
    
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        
        final User userUpdated = userService.update(user);
            
        return ResponseEntity.ok(userUpdated);
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable("id") long id) {
        
        boolean success = userService.delete(id);
        
        return ResponseEntity.ok(success);
        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        
        final User user = userService.getUser(id);
        
        return Objects.nonNull(user) ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
        
    }
   
}
