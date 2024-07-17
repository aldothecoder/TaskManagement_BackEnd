package com.example.TaskManagement.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.TaskManagement.Entity.User;
import com.example.TaskManagement.Service.UserService;

public interface UserRepository extends JpaRepository<User,Integer>{

    @Query("INSERT INTO User(username, password, first_name, last_name) VALUES(:username,:password,:first_name,:last_name)")
    public User insertUser(@Param("username") String username,@Param("password") String password, @Param("first_name") String first_name, @Param("last_name") String last_name);
    
}
