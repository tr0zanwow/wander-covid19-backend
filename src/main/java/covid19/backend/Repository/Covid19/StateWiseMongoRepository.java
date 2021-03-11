package covid19.backend.Repository.Covid19;

import covid19.backend.Models.MongoDB.MongoCasesStateWise;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StateWiseMongoRepository extends MongoRepository<MongoCasesStateWise,String> {
    MongoCasesStateWise findByState(String state);
}