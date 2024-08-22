package com.example.TaskManagement.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.TaskManagement.Entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    
    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User findUserByUsername(@Param("username")String username);

}
