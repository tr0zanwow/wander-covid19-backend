package covid19.backend.Repository.Covid19;

import covid19.backend.Models.MongoDB.MongoCasesStateSeries;
import covid19.backend.Models.MongoDB.MongoCasesStateWise;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StateSeriesMongoRepository extends MongoRepository<MongoCasesStateSeries,String> {
    MongoCasesStateSeries findByState(String state);
}