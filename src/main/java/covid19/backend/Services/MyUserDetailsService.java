package covid19.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import covid19.backend.Models.MyUserDetails;
import covid19.backend.Models.User;
import covid19.backend.Repository.UserRepository;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User retrievdUser = userRepository.findByUserName(userName);
        if (retrievdUser == null) {
            throw new UsernameNotFoundException("No found user with email: " + userName);
        }

        return new org.springframework.security.core.userdetails.User(retrievdUser.getEmail(),retrievdUser.getPassword(),new ArrayList<>());
    }

}
