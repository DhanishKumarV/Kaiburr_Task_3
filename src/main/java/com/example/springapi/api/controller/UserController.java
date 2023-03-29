package com.example.springapi.api.controller;

import com.example.springapi.api.model.User;
import com.example.springapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    private UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/user")
    public Object getUser(@RequestParam Integer id) {
        Optional<User> user = userService.getUser(id);
        if (user.isPresent()){
            return user.get();
        }
        return "404 Value not found";
    }

    @DeleteMapping("/user")
    public String deleteUser(@RequestParam Integer id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return "User with ID " + id + " deleted";
        }
        return "404 Value not found";
    }
    @PutMapping("/user")
    public String updateUser(@RequestBody User user) {
        Optional<User> existingUser = userService.getUser(user.getId());
        if (existingUser.isPresent()) {
            userService.updateUser(user);
            return "User with ID " + user.getId() + " updated";
        } else {
            return "404 Value not found";
        }
    }
}