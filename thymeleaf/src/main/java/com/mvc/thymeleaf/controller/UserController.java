package com.mvc.thymeleaf.controller;

import com.mvc.thymeleaf.dto.UsersRequestDto;
import com.mvc.thymeleaf.entity.Users;
import com.mvc.thymeleaf.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());
        return "registration";
    }

    @PostMapping("/register")
    public ResponseEntity<String> processRegistration(@ModelAttribute("users") UsersRequestDto users) {
        userService.saveUser(users);
        return ResponseEntity.status(HttpStatus.OK).body("User registered successfully");
    }
    @GetMapping("/admin")
    public String showAdminPanel(Model model) {
        String username = userService.greeting();
        model.addAttribute("username",username);
        return "admin";
    }

    @GetMapping("/users")
    public String showUsersPanel(Model model) {
        String username = userService.greeting();
        model.addAttribute("username",username);
        return "users";
    }
}
