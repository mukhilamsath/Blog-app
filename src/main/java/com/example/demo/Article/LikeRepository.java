package com.example.demo.Article;

import com.example.demo.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, Integer> {
    boolean existsByUserAndArticle(UserEntity user, ArticleEntity article);
    void deleteByUserAndArticle(UserEntity user, ArticleEntity article);
    int countByArticle(ArticleEntity article);
}
