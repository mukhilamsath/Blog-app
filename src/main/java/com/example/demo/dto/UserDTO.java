package com.example.demo.dto;

public class UserDTO {
    private int userId;
    private String username;
    private String email;
    private String bio;
    private String image;
    private int followersCount;
    private int followingCount;
    private boolean isFollowedByCurrentUser;

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public int getFollowersCount() { return followersCount; }
    public void setFollowersCount(int followersCount) { this.followersCount = followersCount; }

    public int getFollowingCount() { return followingCount; }
    public void setFollowingCount(int followingCount) { this.followingCount = followingCount; }

    public boolean isFollowedByCurrentUser() { return isFollowedByCurrentUser; }
    public void setFollowedByCurrentUser(boolean followedByCurrentUser) { isFollowedByCurrentUser = followedByCurrentUser; }
}
