package net.iouhase.gilbert.usecase;

import net.iouhase.gilbert.application.ProductRepository;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
