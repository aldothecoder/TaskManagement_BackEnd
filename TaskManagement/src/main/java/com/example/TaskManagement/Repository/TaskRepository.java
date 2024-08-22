package com.example.TaskManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.TaskManagement.Entity.Task;

public interface TaskRepository extends JpaRepository<Task,Integer> {
    
    @Query("SELECT t FROM Task t WHERE t.user.id = :user_id")
    public List<Task> getAllTasksById(@Param("user_id") int user_id);

}
