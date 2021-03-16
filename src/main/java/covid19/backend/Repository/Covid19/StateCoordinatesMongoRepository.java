package covid19.backend.Repository.Covid19;

import covid19.backend.Models.MongoDB.MongoStateCoordinates;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StateCoordinatesMongoRepository extends MongoRepository<MongoStateCoordinates,String> {
    MongoStateCoordinates findByState(String state);
}
