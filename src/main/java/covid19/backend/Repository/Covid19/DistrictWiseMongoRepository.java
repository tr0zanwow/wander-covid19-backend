package covid19.backend.Repository.Covid19;

import covid19.backend.Models.MongoDB.MongoCasesDistrictWise;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface DistrictWiseMongoRepository extends MongoRepository<MongoCasesDistrictWise,String> {
    List<MongoCasesDistrictWise> findByState(String state);
    MongoCasesDistrictWise findByDistrict(String district);
}