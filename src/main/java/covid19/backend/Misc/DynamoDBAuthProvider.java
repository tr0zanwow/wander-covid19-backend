package covid19.backend.Misc;

import java.util.ArrayList;

import covid19.backend.Models.UserSignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import covid19.backend.Repository.UserAuthRepository;

@Component
public class DynamoDBAuthProvider implements AuthenticationProvider {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (Boolean.TRUE.equals(userAuthRepository.login(new UserSignUpRequest(username, password)))) {

            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
