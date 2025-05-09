package net.iouhase.gilbert.controller;

import net.iouhase.gilbert.model.Product;
import net.iouhase.gilbert.usecase.ProductService;

public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
}
