package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FollowService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public boolean toggleFollow(int followerId, int followingId) {
        if (followerId == followingId) return false;

        UserEntity follower = userRepository.findById(followerId)
                .orElseThrow(() -> new RuntimeException("Follower not found"));
        UserEntity following = userRepository.findById(followingId)
                .orElseThrow(() -> new RuntimeException("Following not found"));

        if (follower.getFollowing().contains(following)) {
            follower.getFollowing().remove(following);
            following.getFollowers().remove(follower);
            userRepository.save(follower);
            return false; // unfollowed
        } else {
            follower.getFollowing().add(following);
            following.getFollowers().add(follower);
            userRepository.save(follower);
            return true; // followed
        }
    }
}
