package com.example.demo.Article;

import com.example.demo.user.UserEntity;
import com.example.demo.user.UserRepository;
import com.example.demo.config.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileStorageService fileStorageService;

    public List<ArticleEntity> getAllArticles() {
        return articleRepository.findAll();
    }

    public ArticleEntity getArticleById(int id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found with id: " + id));
    }

    public ArticleEntity saveArticle(ArticleEntity article, int userId) {
        return saveArticleWithImage(article, userId, null);
    }

    public ArticleEntity saveArticleWithImage(ArticleEntity article, int userId, MultipartFile imageFile) {
        UserEntity author = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        article.setAuthor(author);

        if (imageFile != null && !imageFile.isEmpty()) {
            String imageUrl = fileStorageService.storeFile(imageFile);
            article.setImageUrl(imageUrl);
        }

        return articleRepository.save(article);
    }

    public void deleteArticle(int id) {
        articleRepository.deleteById(id);
    }

    public ArticleEntity updateArticle(int id, ArticleEntity updatedArticle) {
        ArticleEntity existing = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found with id: " + id));
        existing.setTitle(updatedArticle.getTitle());
        existing.setBody(updatedArticle.getBody());
        return articleRepository.save(existing);
    }
}
