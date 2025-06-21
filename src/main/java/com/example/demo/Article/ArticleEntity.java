package com.example.demo.Article;

import jakarta.persistence.*;
import com.example.demo.user.UserEntity;

@Entity
@Table(name = "articles")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String subtitle;
    @Column(columnDefinition = "LONGTEXT")
    private String body;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity author;

    // Getters and Setters
    public int getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public UserEntity getAuthor() { return author; }
    public void setAuthor(UserEntity author) { this.author = author; }

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
}
