package covid19.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import covid19.backend.Models.UserSignUpRequest;
import covid19.backend.Repository.UserAuthRepository;

import java.util.ArrayList;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserSignUpRequest retrievedUserSignUpRequest = userAuthRepository.findByUserName(userName);
        if (retrievedUserSignUpRequest == null) {
            throw new UsernameNotFoundException("No found user with email: " + userName);
        }
        return new org.springframework.security.core.userdetails.User(retrievedUserSignUpRequest.getEmail(), retrievedUserSignUpRequest.getPassword(),new ArrayList<>());
    }

}
