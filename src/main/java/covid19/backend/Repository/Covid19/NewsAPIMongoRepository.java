package covid19.backend.Repository.Covid19;

import covid19.backend.Models.MongoDB.MongoCovidNews;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsAPIMongoRepository extends MongoRepository<MongoCovidNews,String> {
}
