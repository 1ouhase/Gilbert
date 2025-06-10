package net.iouhase.gilbert.controller;

import net.iouhase.gilbert.exception.ResourceNotFoundException;
import net.iouhase.gilbert.model.Product;
import net.iouhase.gilbert.model.User;
import net.iouhase.gilbert.usecase.ProductService;
import net.iouhase.gilbert.usecase.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserService userService;
    private final ProductService productService;

    public UserController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        List<Product> products = productService.findAll();
        logger.info("Found {} products", products.size());
        model.addAttribute("products", products);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = new User();
        user.setUsername(auth.getName());
        user = userService.findByUsername(user);
        if (user.getEmail() == null){
            throw new ResourceNotFoundException("something went wrong when fetching user");
        }
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/favorites")
    public String favorites(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = new User();
        user.setUsername(auth.getName());
        user = userService.findByUsername(user);
        List<Product> products = productService.findFavorite(user);
        model.addAttribute("products", products);
        return "favorites";
    }

    @GetMapping("/notifications")
    public String notifications() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = new User();
        user.setUsername(auth.getName());
        user = userService.findByUsername(user);
        List<Product> products = productService.findFavorite(user);
        //userService.checkPrice();
        return "notifications";
    }

    @GetMapping("/updateUser")
    public String updateUser(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = new User();
        user.setUsername(auth.getName());
        user = userService.findByUsername(user);
        if (user.getEmail() == null){
            throw new ResourceNotFoundException("something went wrong when trying to update user");
        }
        model.addAttribute("user", user);
        return "updateUser";
    }

    @PostMapping("/editUser")
    public String editUser(@RequestParam String username, @RequestParam String password, @RequestParam String realName, @RequestParam String img) {
        User user = new User();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        user.setUsername(auth.getName());
        user = userService.findByUsername(user);
        if (user.getEmail() == null){
            throw new ResourceNotFoundException("something went wrong when trying to update user");
        }
        user.setUsername(username);
        user.setPassword(password);
        user.setRealName(realName);
        user.setImg(img);
        userService.update(user);
        return "redirect:/profile";
    }
}
