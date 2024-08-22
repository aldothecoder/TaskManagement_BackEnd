package com.example.TaskManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskManagement.Entity.Task;
import com.example.TaskManagement.Entity.User;
import com.example.TaskManagement.Service.TaskService;
import com.example.TaskManagement.Service.UserService;

@CrossOrigin(origins = "http://127.0.0.1:5173/")
@RestController
public class TaskManagementController{

    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @PostMapping(value = "/register")
    public ResponseEntity<User> registerUser(@RequestBody User value){

        User userFound = userService.getUserByUsername(value.getUsername());

        if(userFound != null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        else{

            if(value.getUsername().length() > 6 && value.getPassword().length() > 6 && value.getFirst_name().length() > 0 && value.getLast_name().length() > 0){
                User user = userService.addUser(value);
                return new ResponseEntity<>(user,HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            }

        }

    }

    @PostMapping(value = "/login")
    public ResponseEntity<User> loginUser(@RequestBody User value){

        User userFound = userService.getUserByUsername(value.getUsername());
        if(userFound != null){
            return new ResponseEntity<>(userFound,HttpStatus.OK);
        }
        else{
            System.out.println("Bad Request");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/user/tasks/{userId}")
    public ResponseEntity<List<Task>> getUsersTasksById(@PathVariable int userId){

        List<Task> tasks = taskService.getTasksByUserId(userId);

        if(tasks == null || tasks.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }
        
    }

    @DeleteMapping(value = "/tasks/{taskId}")
    public void deleteTask(@PathVariable int taskId){
        taskService.deleteTaskById(taskId);
    }

}