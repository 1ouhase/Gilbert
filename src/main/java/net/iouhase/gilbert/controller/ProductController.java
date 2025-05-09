package net.iouhase.gilbert.controller;

import net.iouhase.gilbert.model.Product;
import net.iouhase.gilbert.usecase.ProductService;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
}
