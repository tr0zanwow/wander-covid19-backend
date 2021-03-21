package covid19.backend.Repository.Covid19;

import covid19.backend.Models.MongoDB.MongoNationLatestData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NationLatestMongoRepository extends MongoRepository<MongoNationLatestData,String> {
}
