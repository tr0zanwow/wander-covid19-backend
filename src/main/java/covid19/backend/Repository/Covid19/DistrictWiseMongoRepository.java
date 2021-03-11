package covid19.backend.Repository.Covid19;

import covid19.backend.Models.MongoDB.MongoCasesDistrictWise;
import covid19.backend.Models.MongoDB.MongoCasesStateWise;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DistrictWiseMongoRepository extends MongoRepository<MongoCasesDistrictWise,String> {
}