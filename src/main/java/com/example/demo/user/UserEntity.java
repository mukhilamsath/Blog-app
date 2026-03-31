package com.example.demo.user;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String email;
    private String password;
    private String username;
    private String bio;
    private String image;

    @ManyToMany
    @JoinTable(
        name = "user_followers",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "follower_id")
    )
    private Set<UserEntity> followers = new HashSet<>();

    @ManyToMany(mappedBy = "followers")
    private Set<UserEntity> following = new HashSet<>();

    // Getters and setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public Set<UserEntity> getFollowers() { return followers; }
    public void setFollowers(Set<UserEntity> followers) { this.followers = followers; }

    public Set<UserEntity> getFollowing() { return following; }
    public void setFollowing(Set<UserEntity> following) { this.following = following; }
}
