package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Article.ArticleEntity;
import com.example.demo.Article.ArticleRepository;
import com.example.demo.Article.ArticleService;
import com.example.demo.Comment.CommentEntity;
import com.example.demo.Comment.CommentPojo;
import com.example.demo.Comment.CommentService;
import com.example.demo.user.UserEntity;

@Controller
public class Landing {

    @Autowired
    private ArticleRepository articleRepository;
    
    @Autowired
    private ArticleService artser;
    @Autowired
    private CommentService comment;
    
    

    @GetMapping("/")
    public String landingPage(Model model) {
        model.addAttribute("title", "Welcome to BlogSpace!");
        List<ArticleEntity> art = artser.getAllArticles();
        model.addAttribute("articles", art);
        return "landing";
    }
    
    @GetMapping("/home")
    public String homepage(Model model)
    {
    	List<ArticleEntity> art = artser.getAllArticles();
        model.addAttribute("articles", art);
        return "landing";
    }

    @GetMapping("/userlogin")
    public String loginPage(Model model) {
        model.addAttribute("registerForm", new UserEntity());
        return "register";
    }

    @GetMapping("/add-article")
    public String addArticle(Model model) {
        model.addAttribute("articleForm", new ArticleEntity());
        return "createarticle";
    }


   
    }
