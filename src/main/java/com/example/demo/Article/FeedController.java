package com.example.demo.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeedController {
    
    @Autowired
    private FeedService feedService;

    @GetMapping("/feed")
    public String showFeed(Model model) {
        int currentUserId = 1; // Mocking logged-in user
        model.addAttribute("articles", feedService.getFeedForUser(currentUserId));
        model.addAttribute("currentUserId", currentUserId);
        return "feed";
    }

    @GetMapping("/explore")
    public String showGlobalFeed(Model model) {
        int currentUserId = 1; // Mocking logged-in user
        model.addAttribute("articles", feedService.getGlobalFeed(currentUserId));
        model.addAttribute("currentUserId", currentUserId);
        return "feed";
    }

    @GetMapping("/")
    public String showHome(Model model) {
        return "redirect:/feed";
    }
}
