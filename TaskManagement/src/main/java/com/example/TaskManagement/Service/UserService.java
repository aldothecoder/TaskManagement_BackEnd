package com.example.TaskManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManagement.Entity.User;
import com.example.TaskManagement.Repository.UserRepository; 

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User getUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    } 

}
