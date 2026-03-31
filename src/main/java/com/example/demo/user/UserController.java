package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(loginService.getAllUsers());
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserEntity registerForm) {
        UserEntity savedUser = loginService.saveUser(registerForm);
        return ResponseEntity.ok(Map.of("message", "Registration successful", "userId", savedUser.getUserId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable int id) {
        return ResponseEntity.ok(loginService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }
}
