package com.example.demo.Article;

import com.example.demo.dto.ArticleDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.user.UserEntity;
import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedService {
    @Autowired
    private ArticleRepository articleRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<ArticleDTO> getFeedForUser(int userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow();
        
        List<UserEntity> authors = new ArrayList<>(user.getFollowing());
        authors.add(user);

        List<ArticleEntity> articles = articleRepository.findByAuthorInOrderByCreatedAtDesc(authors);
        return articles.stream().map(a -> convertToDTO(a, user)).collect(Collectors.toList());
    }
    
    @Transactional(readOnly = true)
    public List<ArticleDTO> getGlobalFeed(int currentUserId) {
        UserEntity user = userRepository.findById(currentUserId).orElse(null);
        List<ArticleEntity> articles = articleRepository.findAllByOrderByCreatedAtDesc();
        return articles.stream().map(a -> convertToDTO(a, user)).collect(Collectors.toList());
    }

    public ArticleDTO convertToDTO(ArticleEntity article, UserEntity currentUser) {
        ArticleDTO dto = new ArticleDTO();
        dto.setId(article.getId());
        dto.setTitle(article.getTitle());
        dto.setSubtitle(article.getSubtitle());
        dto.setBody(article.getBody());
        dto.setImageUrl(article.getImageUrl());
        dto.setCreatedAt(article.getCreatedAt());
        dto.setLikesCount(article.getLikes().size());
        
        if (currentUser != null) {
            boolean liked = article.getLikes().stream()
                    .anyMatch(l -> l.getUser().getUserId() == currentUser.getUserId());
            dto.setLikedByCurrentUser(liked);
        }

        UserDTO authorDTO = new UserDTO();
        authorDTO.setUserId(article.getAuthor().getUserId());
        authorDTO.setUsername(article.getAuthor().getUsername());
        authorDTO.setImage(article.getAuthor().getImage());
        dto.setAuthor(authorDTO);

        return dto;
    }
}
