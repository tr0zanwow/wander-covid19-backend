package covid19.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import covid19.backend.Models.AuthResponse;
import covid19.backend.Models.SignUpResponse;
import covid19.backend.Models.User;
import covid19.backend.Repository.UserRepository;
import covid19.backend.Services.MyUserDetailsService;
import covid19.backend.Utils.JWTUtil;

@RestController
public class BackendResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    MyUserDetailsService uDetailsService;

    @Autowired
    JWTUtil jwtTokenUtil;

    @GetMapping("/home")
    public String home() {
        return "Website Dashboard";
    }

    @PostMapping("/auth/register")
    public SignUpResponse register(@RequestBody User user) {
        return userRepository.register(user);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody User user) throws Exception {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect Username or password");
        }

        final UserDetails userDetails = this.uDetailsService.loadUserByUsername(user.getEmail());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(user.getEmail(), jwt));
    }
}
