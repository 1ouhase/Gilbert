package net.iouhase.gilbert.controller;

import net.iouhase.gilbert.usecase.UserService;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
