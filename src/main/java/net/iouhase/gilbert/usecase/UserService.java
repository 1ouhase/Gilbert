package net.iouhase.gilbert.usecase;

import net.iouhase.gilbert.application.UserRepository;
import net.iouhase.gilbert.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User findByEmail(User user) {
        return userRepository.findByEmail(user);
    }

    public User findByUsername(User user) {
        return userRepository.findByUsername(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
