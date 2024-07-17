package com.example.TaskManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManagement.Entity.User;
import com.example.TaskManagement.Repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public User addUser(String username, String password, String first_name, String last_name){
        return userRepository.insertUser(username,password,first_name,last_name);
    }

}
