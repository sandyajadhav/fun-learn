package edu.funlearn.controller;

import edu.funlearn.dto.LoginRequest;
import edu.funlearn.dto.User;
import edu.funlearn.service.UserService;
import edu.funlearn.utils.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@Tag(description = "User", name = "user")
public class UserController {

    @Autowired
    private  UserService userService;

    @Autowired
    private   JwtUtil jwtUtil;


    @PostMapping
    @Operation(summary = "Add User")
    public Mono<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    @Operation(summary = "Login")
    public Mono<ResponseEntity<?>> login(@RequestBody LoginRequest loginRequest) {
        return userService.findUserByUsername(loginRequest.getUsername())
                .flatMap(user -> {
                    // Validate the password
                    if (user.getPassword().equals(loginRequest.getPassword())) {
                        String token = jwtUtil.generateToken(user.getUsername());
                        return Mono.just(ResponseEntity.ok(Map.of("token", token))); // Return response directly
                    } else {
                        return Mono.just(ResponseEntity.status(401).body("Invalid username or password"));
                    }
                })
                .switchIfEmpty(Mono.just(ResponseEntity.status(401).body("Invalid username or password"))); // Handle case where user is not found
    }
}



