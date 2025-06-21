package com.example.demo.Comment;

import com.example.demo.Article.ArticleEntity;
import com.example.demo.Article.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentEntity> getCommentsByArticleId(int articleId) {
        ArticleEntity article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        return commentRepository.findByArticle(article);
    }

    public CommentEntity saveComment(CommentEntity comment) {
        return commentRepository.save(comment);
    }
}
