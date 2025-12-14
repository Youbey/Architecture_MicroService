package com.example.msuser.controller;

import com.example.msuser.entity.User;
import com.example.msuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Add a User
    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    //Read all users
    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //Read a user
    @GetMapping("/{id}")
    public Optional<User> GetUserbyid(@PathVariable Long id){
        return userRepository.findById(id);
    }
}
