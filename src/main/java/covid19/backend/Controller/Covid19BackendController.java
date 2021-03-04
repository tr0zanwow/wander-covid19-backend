package covid19.backend.Controller;

import covid19.backend.Models.UserSignUpRequest;
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
import covid19.backend.Models.UserSignInResponse;
import covid19.backend.Models.UserSignUpResponse;
import covid19.backend.Repository.UserAuthRepository;
import covid19.backend.Services.UserAuthService;
import covid19.backend.Utils.JWTUtil;

@RestController
public class Covid19BackendController {

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    UserAuthService uDetailsService;

    @Autowired
    JWTUtil jwtTokenUtil;

    @GetMapping("/home")
    public String home() {
        return "Website Dashboard";
    }

    @PostMapping("/auth/register")
    public UserSignUpResponse register(@RequestBody UserSignUpRequest userSignUpRequest) {
        return userAuthRepository.register(userSignUpRequest);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody UserSignUpRequest userSignUpRequest) throws Exception {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(userSignUpRequest.getEmail(), userSignUpRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect Username or password");
        }

        final UserDetails userDetails = this.uDetailsService.loadUserByUsername(userSignUpRequest.getEmail());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new UserSignInResponse(userSignUpRequest.getEmail(), jwt));
    }
}
