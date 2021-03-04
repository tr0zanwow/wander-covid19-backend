package covid19.backend.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
import covid19.backend.Models.SignUpResponse;
import covid19.backend.Models.User;

@Repository
public class UserRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Boolean login(User user) {

        Map<String, AttributeValue> eav = new HashMap<>();
        eav.put(":emailInput", new AttributeValue().withS(user.getEmail()));

        List<User> foundEmail = dynamoDBMapper.scan(User.class, new DynamoDBScanExpression()
                .withFilterExpression("email = :emailInput").withExpressionAttributeValues(eav));

        if (!foundEmail.isEmpty()) {
            if (Boolean.FALSE.equals(foundEmail.get(0).verifyHashedPassword(user.getPassword()))) {
                throw new ResponseStatusException(HttpStatus.SC_BAD_REQUEST, "Wrong Credentials", null);
            }
        } else if (foundEmail.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.SC_BAD_REQUEST,
                    "No account found with email: " + user.getEmail(), null);
        }
        return true;
    }

    public User findByUserName(String uName) {
        Map<String, AttributeValue> eav = new HashMap<>();
        eav.put(":emailInput", new AttributeValue().withS(uName));

        List<User> foundEmail = dynamoDBMapper.scan(User.class, new DynamoDBScanExpression()
                .withFilterExpression("email = :emailInput").withExpressionAttributeValues(eav));

        return foundEmail.get(0);
    }

    public SignUpResponse register(User user) {
        user.setHashedPassword();
        dynamoDBMapper.save(user);
        return new SignUpResponse(user.getUuid(), user.getEmail());
    }

}
