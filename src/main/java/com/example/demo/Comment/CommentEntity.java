package com.example.demo.Comment;

import jakarta.persistence.*;
import com.example.demo.Article.ArticleEntity;
import com.example.demo.user.UserEntity;

@Entity
@Table(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private ArticleEntity article;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    // Getters and setters
    public int getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public ArticleEntity getArticle() { return article; }
    public void setArticle(ArticleEntity article) { this.article = article; }

    public UserEntity getUser() { return user; }
    public void setUser(UserEntity user) { this.user = user; }
}
