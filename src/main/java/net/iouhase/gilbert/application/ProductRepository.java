package net.iouhase.gilbert.application;

import net.iouhase.gilbert.model.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Product product) {
        String sql = "INSERT INTO product VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, product.getCategory(), product.getName(), product.getItemNumber());
    }

    public Product findByItemNumber(Product product) {
        String sql = "SELECT * FROM product WHERE itemNumber = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), product);
    }
    public List<Product> findAll() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }
    public List<Product> findByCategory(Product product) {
        String sql = "SELECT * FROM product WHERE category = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class), product.getCategory());
    }
    public void update(Product product) {
        String sql = "UPDATE product SET category = ?, name = ?, WHERE itemNumber = ?";
        jdbcTemplate.update(sql, product.getCategory(), product.getName(), product.getItemNumber());
    }
    public void delete(Product product) {
        String sql = "DELETE FROM product WHERE itemNumber = ?";
        jdbcTemplate.update(sql, product.getItemNumber());
    }
}
