package com.example.TaskManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskManagement.Entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

    
    
}
