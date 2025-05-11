package net.iouhase.gilbert.controller;

import net.iouhase.gilbert.model.User;
import net.iouhase.gilbert.usecase.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/liked")
    public String liked() {
        return "liked";
    }

    @GetMapping("/notifications")
    public String notifications() {
        return "notifications";
    }

    @GetMapping("/updateUser/{email}")
    public String updateUser(@PathVariable String email, Model model) {
        User user = new User();
        user.setEmail(email);
        //model.addAttribute("user", userService.findByEmail(user));
        return "updateUser";
    }

    @PostMapping("/editUser/{email}")
    public String editUser(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //userService.update(user);
        return "redirect:/profile";
    }

    @PostMapping("/createUser")
    public String createUser(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        //userService.save(user);
        return "redirect:/login";
    }

    @PostMapping("/deleteUser/{email}")
    public String deleteUser(@PathVariable String email) {
        User user = new User();
        user.setEmail(email);
        //userService.delete(user);
        return "redirect:/";
    }
}
