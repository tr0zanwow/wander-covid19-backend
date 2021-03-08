package covid19.backend.Controller;

import covid19.backend.Models.UserSignInRequest;
import covid19.backend.Models.UserSignUpRequest;
import covid19.backend.Services.CovidDataSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import covid19.backend.Models.UserSignInResponse;
import covid19.backend.Models.UserSignUpResponse;
import covid19.backend.Services.UserAuthService;
import covid19.backend.Utils.JWTUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;

@RestController
public class Covid19BackendController {
    @Autowired
    UserAuthService userAuthService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    CovidDataSyncService dataSyncService;

    @Autowired
    JWTUtil jwtTokenUtil;

    @GetMapping("/")
    public String home() {
        return "Website Dashboard";
    }

    @GetMapping("/verifyaccount")
    public ModelAndView verifyaccount(@RequestParam(value = "token", defaultValue = "", required = true) String token) {
        return userAuthService.verifyUserToken(token);
    }

    @GetMapping("/getdata")
    public void getCovidData() throws Exception {
        dataSyncService.getDataNation();
    }

    @PostMapping("/signup")
    public UserSignUpResponse register(@RequestBody UserSignUpRequest userSignUpRequest) throws MessagingException {
        return userAuthService.registerUser(userSignUpRequest);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody UserSignInRequest userSignInRequest) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(userSignInRequest.getemail(), userSignInRequest.getPassword()));
        final UserDetails userDetails = userAuthService.loadUserByUsername(userSignInRequest.getemail());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new UserSignInResponse(userSignInRequest.getemail(), jwt));
    }
}
