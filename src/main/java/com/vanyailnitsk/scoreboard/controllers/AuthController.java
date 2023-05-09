package com.vanyailnitsk.scoreboard.controllers;

import com.vanyailnitsk.scoreboard.models.AuthenticationRequest;
import com.vanyailnitsk.scoreboard.models.RegisterRequest;
import com.vanyailnitsk.scoreboard.models.User;
import com.vanyailnitsk.scoreboard.services.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    private final UserService userService;

    private final AuthenticationProvider authenticationManager;

    public AuthController(UserService userService, AuthenticationProvider authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("register")
    public User register(@RequestBody RegisterRequest request) {
        return userService.createUser(request);
    }

    @PostMapping("login")
    public User login(@RequestBody AuthenticationRequest request) {
        System.out.println(request.getEmail());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),request.getPassword()
                )
        );
        return userService.getUserByEmail(request.getEmail());
    }

}
