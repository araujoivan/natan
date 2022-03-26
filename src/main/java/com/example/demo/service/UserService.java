/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eder_Crespo
 */
@Service
public class UserService {
    
    private List<User> userList = new ArrayList();

    public User save(User user) {
        
        var userId = new Random().nextInt(10000);
        
        user.setId(userId);
        
        userList.add(user);
        
        return user;
        
    }

    public boolean delete(long id) {
        
        boolean success = userList.removeIf(user -> user.getId() == id);
        
        return success;
    }

    public User update(User user) {
        
        User userFound = getUserById(user.getId());
     
        if(Objects.nonNull(userFound)) {
            
            userFound.setName(user.getName());
            userFound.setAge(user.getAge());
            
        }
        
        return user;
        
    }

    public User getUser(long id) {
      
        final User userFound = getUserById(id);
        
        return userFound;
    }
    
    private User getUserById(long id) {
        
        User userFound = null;
        
        for(User u : userList) {
            
            if(id == u.getId()) {
                userFound = u;
                break;
            }            
        }
        
        return userFound;
    }
    
}
