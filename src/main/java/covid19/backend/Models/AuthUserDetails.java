package covid19.backend.Models;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthUserDetails implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    UserSignUpRequest retrievdUserSignUpRequest;

    public AuthUserDetails(UserSignUpRequest retrievdUserSignUpRequest) {
        this.retrievdUserSignUpRequest = retrievdUserSignUpRequest;
    }

    public AuthUserDetails() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
