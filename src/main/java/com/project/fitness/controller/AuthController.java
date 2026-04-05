package com.project.fitness.controller;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;
import com.project.fitness.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest registerRequest){
        return userService.register(registerRequest);
    }
}
