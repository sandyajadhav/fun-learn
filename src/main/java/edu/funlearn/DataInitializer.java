/*
package edu.funlearn;

import edu.funlearn.dto.User;
import edu.funlearn.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;

    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setId(123L);
        user.setPassword("admin");
        user.setUsername("admin");

        userService.createUser(user).subscribe();
    }
}

*/
