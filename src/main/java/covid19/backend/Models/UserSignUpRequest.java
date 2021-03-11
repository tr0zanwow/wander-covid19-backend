package covid19.backend.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.security.SecureRandom;

@Document(collection = "users")
public class UserSignUpRequest {

    @Id
    private String uuid;
    private String email;
    private String password;
    private Boolean enabled;
    private String verificationToken;

    public UserSignUpRequest() {
        this.enabled = false;
    }

    public UserSignUpRequest(String uuid, String email, String password, Boolean enabled, String verificationToken) {
        this.uuid = uuid;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.verificationToken = verificationToken;
    }

    public UserSignUpRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getverificationToken() {
        return verificationToken;
    }

    public void setverificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BCryptPasswordEncoder bCryptEncoder() {
        final int strength = 10;
        return new BCryptPasswordEncoder(strength, new SecureRandom());
    }

    public void setHashedPassword() {
        this.password = bCryptEncoder().encode(this.password);
    }

    public Boolean verifyHashedPassword(String password) {
        return bCryptEncoder().matches(password, this.password);
    }
}
