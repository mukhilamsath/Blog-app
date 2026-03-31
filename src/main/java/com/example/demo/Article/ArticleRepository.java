package com.example.demo.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.user.UserEntity;
import java.util.Collection;
import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {
    List<ArticleEntity> findByAuthorInOrderByCreatedAtDesc(Collection<UserEntity> authors);
    List<ArticleEntity> findAllByOrderByCreatedAtDesc();
}
