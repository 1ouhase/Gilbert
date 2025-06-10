package net.iouhase.gilbert.application;

import net.iouhase.gilbert.model.Product;
import net.iouhase.gilbert.model.User;
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
        String sql = "INSERT INTO product VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, product.getItemNumber(), product.getModel(), product.getCategory(), product.getPrice(), product.getSize(), product.getImage());
    }

    public Product findByItemNumber(Product product) {
        String sql = "SELECT * FROM product WHERE itemNumber = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), product);
    }
    public List<Product> findAll() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }
    public List<Product> findFavorite(User user) {
        String sql = "SELECT * FROM gilbert.favorites inner join product on favorites.FKitemNumber=product.itemNumber where FKemail=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class), user.getEmail());
    }
    public List<Product> findByCategory(Product product) {
        String sql = "SELECT * FROM product WHERE category = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class), product.getCategory());
    }
    public void update(Product product) {
        String sql = "UPDATE product SET model = ?, category = ?, price = ?, size = ?, image = ?, WHERE itemNumber = ?";
        jdbcTemplate.update(sql, product.getModel(), product.getCategory(), product.getPrice(), product.getSize() ,product.getImage(), product.getItemNumber());
    }
    public void delete(Product product) {
        String sql = "DELETE FROM product WHERE itemNumber = ?";
        jdbcTemplate.update(sql, product.getItemNumber());
    }
}