package com.example.demo.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Comment.CommentEntity;
import com.example.demo.Comment.CommentPojo;
import com.example.demo.Comment.CommentRepository;
import com.example.demo.Comment.CommentService;
import com.example.demo.user.UserEntity;
import com.example.demo.user.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private CommentService commentService;


    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/form")
    public String showArticleForm(Model model) {
        model.addAttribute("article", new ArticleEntity());
        return "createarticle"; 
    }

    @PostMapping("/save")
    public String createArticle(@ModelAttribute ArticleEntity article, 
                                @RequestParam int authorId,
                                @RequestParam(value = "imageFile", required = false) MultipartFile imageFile) {
        articleService.saveArticleWithImage(article, authorId, imageFile);
        return "redirect:/feed";
    }

    // API methods below (if needed)
   


    @ResponseBody
    @PutMapping("/update/{id}")
    public ArticleEntity updateArticle(@PathVariable int id, @RequestBody ArticleEntity article) {
        return articleService.updateArticle(id, article);
    }

    @ResponseBody
    @DeleteMapping("/udelete/{id}")
    public void deleteArticle(@PathVariable int id) {
        articleService.deleteArticle(id);
    }
    @GetMapping("/view/{id}")
    public String viewArticle(@PathVariable int id, Model model) {
        ArticleEntity article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));

        List<CommentEntity> comments = commentRepository.findByArticle(article);

        // Prepare an empty comment with associations set
        CommentEntity newComment = new CommentEntity();
        newComment.setArticle(article);

        // Simulate logged-in user
        UserEntity user = userRepository.findById(1).orElseThrow(); // Replace with session logic
        newComment.setUser(user);

        model.addAttribute("article", article);
        model.addAttribute("comments", comments);
        model.addAttribute("newComment", newComment);

        return "viewarticle";
    }
}
