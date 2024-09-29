package edu.funlearn.controller;

import edu.funlearn.dto.LoginRequest;
import edu.funlearn.dto.User;
import edu.funlearn.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Tag(description = "User", name = "user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    @Operation(summary = "Add User")
    public Mono<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

   @PostMapping("/login")
    @Operation(summary = "Login")
    public Mono<ResponseEntity<String>> login(@RequestBody LoginRequest loginRequest) {
        return userService.findUserByUsername(loginRequest.getUsername())
                .filter(user -> user.getPassword().equals(loginRequest.getPassword()))
                .flatMap(user -> {
                    return Mono.just(ResponseEntity.ok("Token"));
                })
                .defaultIfEmpty(ResponseEntity.status(401).body("Invalid username or password"));
    }
}



