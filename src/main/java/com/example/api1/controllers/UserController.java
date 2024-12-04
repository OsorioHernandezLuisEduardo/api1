package com.example.api1.controllers;

import com.example.api1.models.User;
import com.example.api1.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import java.util.Date;

@RestController
public class UserController {

    @PostMapping("/login")
    public String login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
        User user = new User();
        user.setUser(username);
        System.out.println(user);
        String token = JwtUtil.generateToken(user.getUser());
        System.out.println("Login request");
        return token;
    }
    @GetMapping("/user")
    public  String getUserName(HttpServletRequest request){
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Missing or invalid Authorization header");
        }
        String token = authorizationHeader.substring(7);
        String username = JwtUtil.extractUsername(token);

        return "Hello, " + username + "! This is your profile.";
    }
}
