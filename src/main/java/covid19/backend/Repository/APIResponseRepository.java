package covid19.backend.Repository;

import covid19.backend.Models.API.*;
import covid19.backend.Models.MongoDB.*;
import covid19.backend.Repository.Covid19.*;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

    @Autowired
    NationSeriesMongoRepository nationSeriesMongoRepository;

    @Autowired
    StateSeriesLongMongoRepository seriesLongMongoRepository;

    @Autowired
    NewsAPIMongoRepository newsAPIMongoRepository;

    @Autowired
    NationLatestMongoRepository nationLatestMongoRepository;

    @Autowired
    StateCodeMappingMongoRepository codeMappingMongoRepository;

    @Autowired
    StateSeriesMongoRepository stateSeriesMongoRepository;

    public GlobalStatsAPIResponse getGlobalStats() {
        MongoGlobalStats globalStats = globalStatsMongoRepository.findAll().get(0);
        MongoNationLatestData nationLatestData = nationLatestMongoRepository.findAll().get(0);
        GlobalStatsAPIResponse.Global global = new GlobalStatsAPIResponse.Global(globalStats.getDate(), String
                .valueOf(globalStats.getTotalActive()), String.valueOf(globalStats.getTotalConfirmed()), String.valueOf(globalStats.getTotalRecovered()), String.valueOf(globalStats.getTotalDeaths()), String.valueOf(globalStats.getNewConfirmed()), String.valueOf(globalStats.getNewRecovered()), String.valueOf(globalStats.getNewDeaths()));
        GlobalStatsAPIResponse.National national = new GlobalStatsAPIResponse.National(String.valueOf(nationLatestData.getTotalConfirmed()));
        return new GlobalStatsAPIResponse(global, national);
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

    public OverviewStatsAPIResponse getOverviewData(String location, String locationType) {
        OverviewStatsAPIResponse.OverviewStats overviewStats;
        List<OverviewStatsAPIResponse.OverviewSeries> overviewSeriesList = new ArrayList<>();
        List<OverviewStatsAPIResponse.OverviewNews> overviewNewsList = new ArrayList<>();
        OverviewStatsAPIResponse overviewStatsAPIResponse = null;

        switch (locationType) {
            case "nation": {
                try {
                    MongoNationLatestData nationLatestData = nationLatestMongoRepository.findAll().get(0);
                    overviewStats = new OverviewStatsAPIResponse.OverviewStats("", String.valueOf(nationLatestData.getActive()), String.valueOf(nationLatestData.getTotalConfirmed()), String.valueOf(nationLatestData.getTotalRecovered()), String.valueOf(nationLatestData.getTotalDeceased()), String.valueOf(nationLatestData.getDailyConfirmed()), String.valueOf(nationLatestData.getDailyRecovered()), String.valueOf(nationLatestData.getDailyDeceased()));

                    List<MongoNationSeries> nationSeriesList = nationSeriesMongoRepository.findAll();
                    for (MongoNationSeries ns : nationSeriesList) {
                        OverviewStatsAPIResponse.OverviewSeries overviewSeries = new OverviewStatsAPIResponse.OverviewSeries(ns.getDate(), String.valueOf(ns.getDailyConfirmed()), String.valueOf(ns.getDailyRecovered()), String.valueOf(ns.getDailyDeceased()));
                        overviewSeriesList.add(overviewSeries);
                    }

                    overviewStatsAPIResponse = new OverviewStatsAPIResponse(overviewStats, overviewSeriesList, new ArrayList<>());
                    break;
                } catch (Exception e) {
                    throw new ResponseStatusException(HttpStatus.SC_NOT_FOUND,
                            "No data found with provided information", null);
                }
            }
            case "state": {
                try {
                    MongoCasesStateWise casesStateWise = stateWiseMongoRepository.findByState(location);
                    overviewStats = new OverviewStatsAPIResponse.OverviewStats("", String.valueOf(casesStateWise.getTotalActive()), String.valueOf(casesStateWise.getConfirmed()), String.valueOf(casesStateWise.getRecovered()), String.valueOf(casesStateWise.getDeaths()), String.valueOf(casesStateWise.getDeltaConfirmed()), String.valueOf(casesStateWise.getDeltaRecovered()), String.valueOf(casesStateWise.getDeltaDeaths()));

                    MongoCasesStateSeries casesStateSeries = stateSeriesMongoRepository.findByState(location);

                    List<OverviewStatsAPIResponse.OverviewSeries> listos = new ArrayList<>();
                    for(MongoCasesStateSeries.DailySeries ds: casesStateSeries.getSeries()){
                        OverviewStatsAPIResponse.OverviewSeries sos = new OverviewStatsAPIResponse.OverviewSeries(ds.getDate(),ds.getConfirmed(),ds.getRecovered(), ds.getDeceased());
                        listos.add(sos);
                    }

                    MongoCovidNews covidNews = newsAPIMongoRepository.findByPlace(location);
                    List<MongoCovidNews.Articles> articlesList = covidNews.getArticles();
                    for (MongoCovidNews.Articles articles : articlesList) {
                        OverviewStatsAPIResponse.OverviewNews overviewNews = new OverviewStatsAPIResponse.OverviewNews(articles.getSourceName(), articles.getTitle(), articles.getUrl(), articles.getImgUrl(), articles.getPublishedAt());
                        overviewNewsList.add(overviewNews);
                    }

                    overviewStatsAPIResponse = new OverviewStatsAPIResponse(overviewStats, listos, overviewNewsList);
                    break;
                } catch (Exception e) {
                    throw new ResponseStatusException(HttpStatus.SC_NOT_FOUND,
                            "No data found with provided information", null);
                }
            }

            case "district": {
                try {
                    MongoCasesDistrictWise casesDistrictWise = districtWiseMongoRepository.findByDistrict(location);
                    overviewStats = new OverviewStatsAPIResponse.OverviewStats("", String.valueOf(casesDistrictWise.getActive()), String.valueOf(casesDistrictWise.getConfirmed()), String.valueOf(casesDistrictWise.getRecovered()), String.valueOf(casesDistrictWise.getDeceased()), String.valueOf(casesDistrictWise.getDeltaConfirmed()), String.valueOf(casesDistrictWise.getDeltaRecovered()), String.valueOf(casesDistrictWise.getDeltaDeceased()));

                    MongoCovidNews covidNews = newsAPIMongoRepository.findByPlace(casesDistrictWise.getState());
                    List<MongoCovidNews.Articles> articlesList = covidNews.getArticles();
                    for (MongoCovidNews.Articles articles : articlesList) {
                        OverviewStatsAPIResponse.OverviewNews overviewNews = new OverviewStatsAPIResponse.OverviewNews(articles.getSourceName(), articles.getTitle(), articles.getUrl(), articles.getImgUrl(), articles.getPublishedAt());
                        overviewNewsList.add(overviewNews);
                    }

                    overviewStatsAPIResponse = new OverviewStatsAPIResponse(overviewStats, new ArrayList<>(), overviewNewsList);
                    break;
                } catch (Exception e) {
                    throw new ResponseStatusException(HttpStatus.SC_NOT_FOUND,
                            "No data found with provided information", null);
                }
            }
            default:
                throw new IllegalStateException("Unexpected value: " + locationType);
        }
        return overviewStatsAPIResponse;
    }
}
