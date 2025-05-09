package net.iouhase.gilbert.controller;

import net.iouhase.gilbert.usecase.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }
}
