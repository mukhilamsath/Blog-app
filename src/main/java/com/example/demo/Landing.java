package com.example.demo;

import com.example.demo.user.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Landing {

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("registerForm", new UserEntity());
        return "register"; // Using the single auth template we currently have
    }
    
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("registerForm", new UserEntity());
        return "register";
    }
}
