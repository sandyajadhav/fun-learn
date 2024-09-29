package edu.funlearn.service;

import edu.funlearn.dto.User;
import edu.funlearn.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> createUser(User user) {;
        return userRepository.save(user);
    }

    public Mono<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

