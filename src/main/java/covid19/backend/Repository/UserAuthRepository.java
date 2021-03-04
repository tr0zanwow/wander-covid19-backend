package covid19.backend.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import covid19.backend.Models.UserSignUpRequest;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
import covid19.backend.Models.UserSignUpResponse;

@Repository
public class UserAuthRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Boolean login(UserSignUpRequest userSignUpRequest) {

        Map<String, AttributeValue> eav = new HashMap<>();
        eav.put(":emailInput", new AttributeValue().withS(userSignUpRequest.getEmail()));

        List<UserSignUpRequest> foundEmail = dynamoDBMapper.scan(UserSignUpRequest.class, new DynamoDBScanExpression()
                .withFilterExpression("email = :emailInput").withExpressionAttributeValues(eav));

        if (!foundEmail.isEmpty()) {
            if (Boolean.FALSE.equals(foundEmail.get(0).verifyHashedPassword(userSignUpRequest.getPassword()))) {
                throw new ResponseStatusException(HttpStatus.SC_BAD_REQUEST, "Wrong Credentials", null);
            }
        } else {
            throw new ResponseStatusException(HttpStatus.SC_BAD_REQUEST,
                    "No account found with email: " + userSignUpRequest.getEmail(), null);
        }
        return true;
    }

    public UserSignUpRequest findByUserName(String uName) {
        Map<String, AttributeValue> eav = new HashMap<>();
        eav.put(":emailInput", new AttributeValue().withS(uName));

        List<UserSignUpRequest> foundEmail = dynamoDBMapper.scan(UserSignUpRequest.class, new DynamoDBScanExpression()
                .withFilterExpression("email = :emailInput").withExpressionAttributeValues(eav));

        return foundEmail.get(0);
    }

    public UserSignUpResponse register(UserSignUpRequest userSignUpRequest) {
        userSignUpRequest.setHashedPassword();
        dynamoDBMapper.save(userSignUpRequest);
        return new UserSignUpResponse(userSignUpRequest.getUuid(), userSignUpRequest.getEmail());
    }

}
