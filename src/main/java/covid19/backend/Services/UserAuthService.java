package covid19.backend.Services;

import covid19.backend.Models.UserSignInRequest;
import covid19.backend.Models.UserSignUpResponse;
import covid19.backend.Repository.SMTPEmailRepository;
import covid19.backend.Repository.UserSignUpMongoRepository;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import covid19.backend.Models.UserSignUpRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.mail.MessagingException;
import java.util.*;

@Service
public class UserAuthService implements UserDetailsService {
    @Autowired
    UserSignUpMongoRepository userSignUpMongoRepository;

    @Autowired
    SMTPEmailRepository emailRepository;

    ModelAndView mv;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserSignUpRequest retrievedUserSignUpRequest = userSignUpMongoRepository.findByEmail(email);
        if (retrievedUserSignUpRequest == null) {
            throw new UsernameNotFoundException("No found user with email: " + email);
        }
        return new org.springframework.security.core.userdetails.User(retrievedUserSignUpRequest.getEmail(), retrievedUserSignUpRequest.getPassword(), new ArrayList<>());
    }

    public UserSignUpResponse registerUser(UserSignUpRequest userSignUpRequest) throws MessagingException {
        if (!userSignUpMongoRepository.findByEmail(userSignUpRequest.getEmail()).getEmail().equals(userSignUpRequest.getEmail())) {
            userSignUpRequest.setHashedPassword();
            String token = UUID.randomUUID().toString();
            userSignUpRequest.setverificationToken(token);
            userSignUpMongoRepository.save(userSignUpRequest);
            final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
            String tokenUrl = baseUrl + "/verifyaccount?token=" + token;
            emailRepository.sendMail(userSignUpRequest.getEmail(), tokenUrl);

            return new UserSignUpResponse(userSignUpRequest.getUuid(), userSignUpRequest.getEmail());
        } else {
            throw new ResponseStatusException(HttpStatus.SC_CONFLICT,
                    "Account already exists with email: " + userSignUpRequest.getEmail(), null);
        }
    }

    public ModelAndView verifyUserToken(String token) {
        UserSignUpRequest foundUser = userSignUpMongoRepository.findByVerificationToken(token);
        if (foundUser.getverificationToken().equals(token)) {
            if (!foundUser.getEnabled()) {
                foundUser.setEnabled(true);
                userSignUpMongoRepository.save(foundUser);
                mv = new ModelAndView("token_verified");
                mv.addObject("email", foundUser.getEmail());
                return mv;
            } else {
                mv = new ModelAndView("token_error_already_verified");
                return mv;
            }
        } else {
            mv = new ModelAndView("token_error");
            return mv;
        }
    }

    public Boolean login(UserSignInRequest userSignInRequest) {

        UserSignUpRequest foundUser = userSignUpMongoRepository.findByEmail(userSignInRequest.getemail());
        if (foundUser != null && foundUser.getEmail().equals(userSignInRequest.getemail())) {
            if (Boolean.FALSE.equals(foundUser.verifyHashedPassword(userSignInRequest.getPassword()))) {
                throw new ResponseStatusException(HttpStatus.SC_UNAUTHORIZED, "Wrong Credentials", null);
            } else if (Boolean.FALSE.equals(foundUser.getEnabled())) {
                throw new ResponseStatusException(HttpStatus.SC_FORBIDDEN, "Account not activated", null);
            }
        } else {
            throw new ResponseStatusException(HttpStatus.SC_NOT_FOUND,
                    "No account found with email: " + userSignInRequest.getemail(), null);
        }
        return true;
    }

}
