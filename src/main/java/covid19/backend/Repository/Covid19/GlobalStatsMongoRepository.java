package covid19.backend.Repository.Covid19;

import covid19.backend.Models.MongoDB.MongoGlobalStats;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GlobalStatsMongoRepository extends MongoRepository<MongoGlobalStats,String> {
}
