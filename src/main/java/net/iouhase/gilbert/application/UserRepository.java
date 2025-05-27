package net.iouhase.gilbert.application;

import net.iouhase.gilbert.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        String sql = "insert into user (email, username, password) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getEmail(), user.getUsername(), user.getPassword(), user.getRealName(), user.getImg(), user.getRole(), user.getSales(), user.getFollowers(), user.getFollowing());
    }
    public User findByEmail(User user) {
        String sql = "select * from user where email = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getEmail());
    }
    public Optional<User> findByUsername(User user) {
        String sql = "select * from user where username = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getUsername()));
    }
    public List<User> findAll() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
    public void update(User user) {
        String sql = "update user set username = ?, password = ?, realName = ?, img = ?, role = ?, sales = ?, followers = ?, following = ? where email = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getRealName(), user.getImg(), user.getRole(), user.getSales(), user.getFollowers(), user.getFollowing() ,user.getEmail());
    }
    public void delete(User user) {
        String sql = "delete from user where email = ?";
        jdbcTemplate.update(sql, user.getEmail());
    }
}