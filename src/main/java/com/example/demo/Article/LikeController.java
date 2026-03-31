package com.example.demo.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/posts")
public class LikeController {
    
    @Autowired
    private LikeService likeService;

    @Autowired
    private ArticleRepository articleRepository;

    @PostMapping("/{id}/like")
    public ResponseEntity<?> toggleLike(@PathVariable int id, @RequestParam int userId) {
        boolean liked = likeService.toggleLike(userId, id);
        ArticleEntity article = articleRepository.findById(id).orElseThrow();
        int count = likeService.getLikesCount(article);
        return ResponseEntity.ok(Map.of("liked", liked, "count", count));
    }
}
