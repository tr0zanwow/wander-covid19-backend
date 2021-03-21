package covid19.backend.Repository.Covid19;

import covid19.backend.Models.MongoDB.MongoStateCodeMapping;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StateCodeMappingMongoRepository extends MongoRepository<MongoStateCodeMapping,String> {
}
