package covid19.backend.Repository;

import covid19.backend.Models.API.GlobalStatsAPIResponse;
import covid19.backend.Models.MongoDB.MongoGlobalStats;
import covid19.backend.Repository.Covid19.GlobalStatsMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class APIResponseRepository {
    @Autowired
    GlobalStatsMongoRepository globalStatsMongoRepository;

    public GlobalStatsAPIResponse getGlobalStats(){
        List<MongoGlobalStats> globalStatsList = globalStatsMongoRepository.findAll();
        MongoGlobalStats globalStats = globalStatsList.get(0);
        return new GlobalStatsAPIResponse(globalStats.getNewConfirmed(), globalStats.getTotalConfirmed(), globalStats.getNewDeaths(), globalStats.getTotalDeaths(), globalStats.getNewRecovered(), globalStats.getTotalRecovered(), globalStats.getTotalActive(), globalStats.getDate());
    }
}
