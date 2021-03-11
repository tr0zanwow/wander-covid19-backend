package covid19.backend.Repository;

import covid19.backend.Models.UserSignUpRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSignUpMongoRepository extends MongoRepository<UserSignUpRequest,String> {
    UserSignUpRequest findByEmail(String email);
    UserSignUpRequest findByVerificationToken(String token);
}
