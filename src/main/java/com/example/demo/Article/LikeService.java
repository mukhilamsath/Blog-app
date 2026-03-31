package com.example.demo.Article;

import com.example.demo.user.UserEntity;
import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public boolean toggleLike(int userId, int articleId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        ArticleEntity article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article not found"));

        if (likeRepository.existsByUserAndArticle(user, article)) {
            likeRepository.deleteByUserAndArticle(user, article);
            return false; // unliked
        } else {
            LikeEntity like = new LikeEntity();
            like.setUser(user);
            like.setArticle(article);
            likeRepository.save(like);
            return true; // liked
        }
    }

    public int getLikesCount(ArticleEntity article) {
        return likeRepository.countByArticle(article);
    }
}
