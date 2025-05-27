package net.iouhase.gilbert.usecase;

import lombok.AllArgsConstructor;
import net.iouhase.gilbert.application.UserRepository;
import net.iouhase.gilbert.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
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
        return userRepository.findByUsername(user).get();
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User tempUser = new User();
        tempUser.setUsername(username);
        Optional<User> user = userRepository.findByUsername(tempUser);

        if (user.isPresent()) {
            User userObj = user.get();
            return org.springframework.security.core.userdetails.User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .build();
        } else {

            throw new UsernameNotFoundException("username not found" + username);
        }
    }
}
