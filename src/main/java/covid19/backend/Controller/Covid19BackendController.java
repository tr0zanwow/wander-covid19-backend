package covid19.backend.Controller;

import covid19.backend.Configuration.CovidDataSyncConfiguration;
import covid19.backend.Models.*;
import covid19.backend.Models.API.GlobalStatsAPIResponse;
import covid19.backend.Repository.APIResponseRepository;
import covid19.backend.Services.CovidDataSyncService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import covid19.backend.Services.UserAuthService;
import covid19.backend.Utils.JWTUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class Covid19BackendController {
    @Autowired
    UserAuthService userAuthService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    CovidDataSyncService dataSyncService;

    @Autowired
    APIResponseRepository apiResponse;

    @Autowired
    JWTUtil jwtTokenUtil;

    @Autowired
    CovidDataSyncConfiguration covidDataSyncConfiguration;

    @GetMapping("/verifyaccount")
    public ModelAndView verifyaccount(@RequestParam(value = "token", defaultValue = "", required = true) String token) {
        return userAuthService.verifyUserToken(token);
    }

    @GetMapping("/synccoordinates")
    public void syncCoordinates() throws IOException {
        covidDataSyncConfiguration.syncCoordinates();
    }

    @GetMapping("/syncdata")
    public void syncData() throws Exception {
        covidDataSyncConfiguration.syncAllData();
    }

    @GetMapping("/syncnews")
    public void syncNewsData() throws Exception {
        covidDataSyncConfiguration.syncNewsData();
    }

    @PostMapping("/signup")
    public UserSignUpResponse register(@RequestBody UserSignUpRequest userSignUpRequest) throws MessagingException {
        return userAuthService.registerUser(userSignUpRequest);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody UserSignInRequest userSignInRequest) {
        if (userSignInRequest.getemail() != null && userSignInRequest.getPassword() != null) {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(userSignInRequest.getemail(), userSignInRequest.getPassword()));
            final UserDetails userDetails = userAuthService.loadUserByUsername(userSignInRequest.getemail());
            final String jwt = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new UserSignInResponse(userSignInRequest.getemail(), jwt));
        } else {
            throw new ResponseStatusException(HttpStatus.SC_UNPROCESSABLE_ENTITY,
                    "Required Parameter Missing: One or more field is missing", null);
        }
    }

    @GetMapping("/globalstats")
    public GlobalStatsAPIResponse getGlobalStats() {
        try {
            return apiResponse.getGlobalStats();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SC_FORBIDDEN,
                    e.getMessage(), null);
        }
    }
}
