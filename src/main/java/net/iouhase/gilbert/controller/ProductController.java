package net.iouhase.gilbert.controller;

import net.iouhase.gilbert.usecase.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/createPost")
    public String advertisement() {
        return "createPost";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }
}