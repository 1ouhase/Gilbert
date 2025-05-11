package net.iouhase.gilbert.controller;

import net.iouhase.gilbert.model.User;
import net.iouhase.gilbert.usecase.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String register() {
        return "register";
    }

    @PostMapping("/req/signup")
    public String createUser(@RequestParam String email, @RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        userService.save(user);
        return "redirect:/login";
    }
}
