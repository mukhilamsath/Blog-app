package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class FollowController {
    
    @Autowired
    private FollowService followService;

    @PostMapping("/{followerId}/follow/{followingId}")
    public ResponseEntity<?> toggleFollow(@PathVariable int followerId, @PathVariable int followingId) {
        boolean followed = followService.toggleFollow(followerId, followingId);
        return ResponseEntity.ok(Map.of("followed", followed));
    }
}
