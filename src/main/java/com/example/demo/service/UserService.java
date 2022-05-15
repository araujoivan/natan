/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.*;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eder_Crespo
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User save(User user) {

        return userRepository.save(user);

    }

    public boolean delete(long id) {

        userRepository.deleteById(id);
        
        return true;
    }

    public User update(User user) {
        return  userRepository.save(user);
    }

    public User getUser(long id) {

        final Optional<User> optUser = userRepository.findById(id);

        // operacao ternaria
        return optUser.isPresent() ? optUser.get() : new User();
    }

}
