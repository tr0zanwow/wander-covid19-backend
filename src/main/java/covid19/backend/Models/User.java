package covid19.backend.Models;

import java.security.SecureRandom;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@DynamoDBTable(tableName = "users")
public class User {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String uuid;

    @DynamoDBAttribute
    private String email;

    @DynamoDBAttribute
    private String password;

    public User() {
    }

    public User(String uuid, String email, String password) {
        this.uuid = uuid;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
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
