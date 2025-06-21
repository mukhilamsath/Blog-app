package com.example.demo.Comment;

import com.example.demo.Article.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    List<CommentEntity> findByArticle(ArticleEntity article);
}
