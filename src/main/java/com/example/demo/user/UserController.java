package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private LoginService userService;

    @GetMapping("/userentity/user/all")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }
   
       
  
    @PostMapping("/userentity/user/add")
    public String addUser(@ModelAttribute UserEntity registerForm) {
        userService.saveUser(registerForm);
       // Or redirect to a success page
       return "landing";
    }


    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable int id) {
        return userService.getUserById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
