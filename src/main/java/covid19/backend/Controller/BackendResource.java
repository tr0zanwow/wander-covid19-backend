package covid19.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import covid19.backend.Models.AuthResponse;
import covid19.backend.Models.User;
import covid19.backend.Repository.UserRepository;

@RestController
public class BackendResource {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/auth/register")
    public User register(@RequestBody User user) {
        return userRepository.register(user);
    }

    @PostMapping("/auth/login")
    public AuthResponse login(@RequestBody User user) {
        return userRepository.login(user);
    }
}
