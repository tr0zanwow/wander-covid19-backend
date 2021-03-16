package covid19.backend.Repository;

import covid19.backend.Models.API.DistrictListAPIResponse;
import covid19.backend.Models.API.GlobalStatsAPIResponse;
import covid19.backend.Models.API.StateListAPIResponse;
import covid19.backend.Models.MongoDB.*;
import covid19.backend.Repository.Covid19.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class APIResponseRepository {
    @Autowired
    GlobalStatsMongoRepository globalStatsMongoRepository;

    @Autowired
    StateWiseMongoRepository stateWiseMongoRepository;

    @Autowired
    StateCoordinatesMongoRepository stateCoordinatesMongoRepository;

    @Autowired
    DistrictWiseMongoRepository districtWiseMongoRepository;

    @Autowired
    DistrictCoordinatesMongoRepository districtCoordinatesMongoRepository;

    public GlobalStatsAPIResponse getGlobalStats() {
        List<MongoGlobalStats> globalStatsList = globalStatsMongoRepository.findAll();
        MongoGlobalStats globalStats = globalStatsList.get(0);
        return new GlobalStatsAPIResponse(globalStats.getNewConfirmed(), globalStats.getTotalConfirmed(), globalStats.getNewDeaths(), globalStats.getTotalDeaths(), globalStats.getNewRecovered(), globalStats.getTotalRecovered(), globalStats.getTotalActive(), globalStats.getDate());
    }

    public List<StateListAPIResponse> getStateList() {
        List<MongoCasesStateWise> casesStateWiseList = stateWiseMongoRepository.findAll();
        List<MongoStateCoordinates> stateCoordinateList = stateCoordinatesMongoRepository.findAll();
        List<StateListAPIResponse> stateListAPIResponseList = new ArrayList<>();
        for (MongoCasesStateWise stateWise : casesStateWiseList.subList(1, casesStateWiseList.size() - 1)) {
            MongoStateCoordinates stateCoordinates = stateCoordinateList.stream().filter(coordinate ->
                    stateWise.getState().equals(coordinate.getState())
            ).findFirst().orElse(null);
            ArrayList<Double> coordinates = new ArrayList<>();
            coordinates.add(stateCoordinates.getLongitude());
            coordinates.add(stateCoordinates.getLatitude());
            StateListAPIResponse apiResponse = new StateListAPIResponse(stateWise.getState(), stateWise.getConfirmed(), coordinates);
            stateListAPIResponseList.add(apiResponse);
        }
        return stateListAPIResponseList;
    }

    public List<DistrictListAPIResponse> getDistrictList(String state) {
        List<MongoCasesDistrictWise> casesDistrictWiseList = districtWiseMongoRepository.findByState(state);
        List<MongoDistrictCoordinates> districtCoordinatesList = districtCoordinatesMongoRepository.findByState(state);
        List<DistrictListAPIResponse> districtListAPIResponse = new ArrayList<>();
        for (MongoCasesDistrictWise casesDistrictWise : casesDistrictWiseList) {
            MongoDistrictCoordinates districtCoordinates = districtCoordinatesList.stream()
                    .filter(mongoDistrictCoordinates ->
                            casesDistrictWise.getDistrict().equals(mongoDistrictCoordinates.getDistrict()))
                    .findFirst().orElse(null);
            if (districtCoordinates != null) {
                ArrayList<Double> coordinates = new ArrayList<>();
                coordinates.add(districtCoordinates.getLongitude());
                coordinates.add(districtCoordinates.getLatitude());
                DistrictListAPIResponse apiResponse = new DistrictListAPIResponse(casesDistrictWise.getDistrict(), casesDistrictWise.getConfirmed(), coordinates);
                districtListAPIResponse.add(apiResponse);
            }
        }
        return districtListAPIResponse;
    }
}
