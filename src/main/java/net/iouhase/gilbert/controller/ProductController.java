package net.iouhase.gilbert.controller;

import net.iouhase.gilbert.model.Product;
import net.iouhase.gilbert.usecase.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/createPost")
    public String getCreatePost() {
        return "createPost";
    }

    @PostMapping("/createPost")
    public String createPost(@RequestParam String name, @RequestParam String category, @RequestParam double price, @RequestParam double size, @RequestParam String picture) {
        Product product = new Product();
        product.setCategory(category);
        product.setModel(name);
        product.setPrice(price);
        product.setSize((int)size);
        product.setImage(picture);
        productService.save(product);
        return "redirect:/profile";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }
}