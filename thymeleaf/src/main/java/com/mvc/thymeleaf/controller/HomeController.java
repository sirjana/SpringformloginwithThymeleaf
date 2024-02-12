package com.mvc.thymeleaf.controller;

import com.mvc.thymeleaf.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private UserServiceImpl userService;

    public HomeController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String greeting(Model model) {  //model contains the data that needs to be displayed or processed in view.
       String username = userService.greeting();
        model.addAttribute("username",username);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}
