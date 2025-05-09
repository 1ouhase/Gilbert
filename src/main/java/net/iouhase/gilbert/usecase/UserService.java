package net.iouhase.gilbert.usecase;

import net.iouhase.gilbert.application.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
