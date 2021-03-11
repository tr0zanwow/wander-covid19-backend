package covid19.backend.Repository.Covid19;

import covid19.backend.Models.MongoDB.MongoCovidVideoNews;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoNewsMongoRepository extends MongoRepository<MongoCovidVideoNews,String> {
}
