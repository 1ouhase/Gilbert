package net.iouhase.gilbert.usecase;

import jdk.jfr.Category;
import net.iouhase.gilbert.application.ProductRepository;
import net.iouhase.gilbert.model.Product;
import net.iouhase.gilbert.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product findByItemNumber(Product product) {
        return productRepository.findByItemNumber(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findFavorite(User user) {
        return productRepository.findFavorite(user);
    }

    public List<Product> findByCategory(Product product) {
        return productRepository.findByCategory(product);
    }

    public void update(Product product) {
        productRepository.update(product);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }
}
