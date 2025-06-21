package com.example.demo.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/addcomments")
  
    public String addComment(@ModelAttribute CommentEntity comment,
                             @RequestParam("articleId") int articleId) {
        commentService.saveComment(comment);

        return "redirect:/articles/view/" + articleId;
    }

   

    @GetMapping("/article/{articleId}")
    public List<CommentEntity> getCommentsByArticle(@PathVariable int articleId) {
        return commentService.getCommentsByArticleId(articleId);
    }
}
