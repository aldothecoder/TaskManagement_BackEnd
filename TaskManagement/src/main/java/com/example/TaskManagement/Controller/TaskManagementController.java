package com.example.TaskManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskManagement.Entity.User;
import com.example.TaskManagement.Service.UserService;

@RestController
public class TaskManagementController{

    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<String> registerUser(@RequestBody User value){

        User user = userService.addUser(value.getUsername(),value.getPassword(),value.getFirst_name(),value.getLast_name());
        return new ResponseEntity<>(HttpStatus.OK);

    }


}