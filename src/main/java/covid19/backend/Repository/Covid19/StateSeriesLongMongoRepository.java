package covid19.backend.Repository.Covid19;

import covid19.backend.Models.MongoDB.MongoCasesStateSeriesLong;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface StateSeriesLongMongoRepository extends MongoRepository<MongoCasesStateSeriesLong,String> {
    List<MongoCasesStateSeriesLong> findByState(String state);
}
