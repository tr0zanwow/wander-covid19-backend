package covid19.backend.Repository.Covid19;

import covid19.backend.Models.MongoDB.MongoNationSeries;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NationSeriesMongoRepository extends MongoRepository<MongoNationSeries,String> {
}
