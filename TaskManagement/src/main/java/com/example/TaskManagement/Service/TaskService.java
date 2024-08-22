package com.example.TaskManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManagement.Entity.Task;
import com.example.TaskManagement.Repository.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    TaskRepository taskRepository;

    public List<Task>getTasksByUserId(Integer user_id){
        return taskRepository.getAllTasksById(user_id);
    }

    public void deleteTaskById(int taskId){
        taskRepository.deleteById(taskId);
    }

}
