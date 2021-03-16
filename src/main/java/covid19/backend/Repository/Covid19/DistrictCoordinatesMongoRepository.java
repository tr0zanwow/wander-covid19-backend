package covid19.backend.Repository.Covid19;

import covid19.backend.Models.MongoDB.MongoDistrictCoordinates;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface DistrictCoordinatesMongoRepository extends MongoRepository<MongoDistrictCoordinates,String> {
    List<MongoDistrictCoordinates> findByState(String state);
}
