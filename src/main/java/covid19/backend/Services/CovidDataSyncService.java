package covid19.backend.Services;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import covid19.backend.Models.Coordinates;
import covid19.backend.Models.Covid19.*;
import covid19.backend.Models.GeoCodeCoordinates;
import covid19.backend.Models.MongoDB.*;
import covid19.backend.Models.NewsAPI;
import covid19.backend.Repository.Covid19.*;
import covid19.backend.Repository.GeoCoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CovidDataSyncService {
    @Autowired
    StateWiseMongoRepository stateWiseMongoRepository;

    @Autowired
    NationSeriesMongoRepository nationSeriesMongoRepository;

    @Autowired
    DistrictWiseMongoRepository districtWiseMongoRepository;

    @Autowired
    StateCoordinatesMongoRepository stateCoordinatesMongoRepo;

    @Autowired
    DistrictCoordinatesMongoRepository districtCoordinatesMongoRepo;

    @Autowired
    StateSeriesMongoRepository stateSeriesMongoRepository;

    @Autowired
    NewsAPIMongoRepository newsAPIMongoRepository;

    @Autowired
    VideoNewsMongoRepository videoNewsMongoRepository;

    @Autowired
    GlobalStatsMongoRepository globalStatsMongoRepository;

    @Autowired
    GeoCoding geoCoding;

    @Autowired
    RestTemplate restTemplate;

    private static final String STATE_WISE_URL = "https://api.covid19india.org/csv/latest/state_wise.csv";
    private static final String STATE_SERIES_URL = "https://api.covid19india.org/csv/latest/state_wise_daily.csv";
    private static final String NATION_SERIES_URL = "https://api.covid19india.org/csv/latest/case_time_series.csv";
    private static final String DISTRICT_WISE_URL = "https://api.covid19india.org/csv/latest/district_wise.csv";
    private static final String GLOBAL_STATS_URL = "https://api.covid19api.com/summary";
    private static final long MAX_SEARCH_RESULTS = 20;

    private BufferedReader getURLReader(String url) throws IOException {
        URL dataUrl = new URL(url);
        return new BufferedReader(
                new InputStreamReader(dataUrl.openStream()));
    }

    public void getDataStateWise() throws Exception {
        CsvToBean<CsvBeanStateWise> swd = new CsvToBeanBuilder(getURLReader(STATE_WISE_URL))
                .withType(CsvBeanStateWise.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        stateWiseMongoRepository.deleteAll();

        for (CsvBeanStateWise sw : swd) {
            MongoCasesStateWise casesStateWise = new MongoCasesStateWise(sw.getDateEpoch(), sw.getState(), sw.getStateCode(), sw.getConfirmed(), sw.getRecovered(), sw.getDeaths(), sw.getActive(), sw.getDeltaConfirmed(), sw.getDeltaRecovered(), sw.getDeltaDeaths());
            stateWiseMongoRepository.save(casesStateWise);
        }
    }

    public void getDataNation() throws Exception {
        CsvToBean<CsvBeanNationSeries> nationSeriesCsvToBean = new CsvToBeanBuilder(getURLReader(NATION_SERIES_URL))
                .withType(CsvBeanNationSeries.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        nationSeriesMongoRepository.deleteAll();

        for (CsvBeanNationSeries ns : nationSeriesCsvToBean) {
            MongoNationSeries mongoNationSeries = new MongoNationSeries(ns.getDate2Epoch(), ns.getdailyConfirmed(), ns.getTotalConfirmed(), ns.getDailyRecovered(), ns.getTotalRecovered(), ns.getDailyDeceased(), ns.getTotalDeceased());
            nationSeriesMongoRepository.save(mongoNationSeries);
        }
    }

    public void getDataDistrictWise() throws Exception {
        CsvToBean<CsvBeanDistrictWise> swd = new CsvToBeanBuilder(getURLReader(DISTRICT_WISE_URL))
                .withType(CsvBeanDistrictWise.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        districtWiseMongoRepository.deleteAll();

        for (CsvBeanDistrictWise sw : swd) {
            MongoCasesDistrictWise casesDistrictWise = new MongoCasesDistrictWise(sw.getState(), sw.getStateCode(), sw.getDistrict(), sw.getConfirmed(), sw.getActive(), sw.getRecovered(), sw.getDeceased(), sw.getDeltaConfirmed(), sw.getDeltaActive(), sw.getDeltaRecovered(), sw.getDeltaDeceased());
            districtWiseMongoRepository.save(casesDistrictWise);
        }
    }

    public void getDataStateSeries() throws Exception {
        CsvToBean<CsvBeanStateSeries> ssd = new CsvToBeanBuilder(getURLReader(STATE_SERIES_URL))
                .withType(CsvBeanStateSeries.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        stateSeriesMongoRepository.deleteAll();

        for (CsvBeanStateSeries ss : ssd) {
            MongoCasesStateSeries casesStateSeries = new MongoCasesStateSeries(ss.getDateEpoch(), ss.getStatus(), ss.getTT(), ss.getAN(), ss.getAP(), ss.getAR(), ss.getAS(), ss.getBR(), ss.getCH(), ss.getCT(), ss.getDN(), ss.getDD(), ss.getDL(), ss.getGA(), ss.getGJ(), ss.getHR(), ss.getHP(), ss.getJK(), ss.getJH(), ss.getKA(), ss.getKL(), ss.getLA(), ss.getLD(), ss.getMP(), ss.getMH(), ss.getMN(), ss.getML(), ss.getMZ(), ss.getNL(), ss.getOR(), ss.getPY(), ss.getPB(), ss.getRJ(), ss.getSK(), ss.getTN(), ss.getTG(), ss.getTR(), ss.getUP(), ss.getUT(), ss.getWB(), ss.getUN());
            stateSeriesMongoRepository.save(casesStateSeries);
        }
    }

    public void getStateCoordinates() throws IOException {
        CsvToBean<CsvBeanStateWise> swd = new CsvToBeanBuilder(getURLReader(STATE_WISE_URL))
                .withType(CsvBeanStateWise.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        stateCoordinatesMongoRepo.deleteAll();

        for (CsvBeanStateWise sw : swd) {
            GeoCodeCoordinates geoCodeCoordinates = geoCoding.getCoordinates(sw.getState());
            Map<String, Coordinates> resultData;
            if (geoCodeCoordinates.getData().size() != 0) {
                resultData = (Map<String, Coordinates>) geoCodeCoordinates.getData().get(0);
                Double longitude = Double.valueOf(String.valueOf(resultData.get("longitude")));
                Double latitude = Double.valueOf(String.valueOf(resultData.get("latitude")));
                MongoStateCoordinates msd = new MongoStateCoordinates(sw.getState(), latitude, longitude);
                stateCoordinatesMongoRepo.save(msd);
            } else {
                MongoStateCoordinates msd = new MongoStateCoordinates(sw.getState(), (double) 0, (double) 0);
                stateCoordinatesMongoRepo.save(msd);
            }
        }
    }

    public void getDistrictCoordinates() throws IOException {
        CsvToBean<CsvBeanDistrictWise> swd = new CsvToBeanBuilder(getURLReader(DISTRICT_WISE_URL))
                .withType(CsvBeanDistrictWise.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        districtCoordinatesMongoRepo.deleteAll();

        for (CsvBeanDistrictWise sw : swd) {
            GeoCodeCoordinates geoCodeCoordinates = geoCoding.getCoordinates(sw.getDistrict() + "," + sw.getState());
            Map<String, Coordinates> resultData;
            if (geoCodeCoordinates.getData().size() != 0) {
                resultData = (Map<String, Coordinates>) geoCodeCoordinates.getData().get(0);
                Double longitude = Double.valueOf(String.valueOf(resultData.get("longitude")));
                Double latitude = Double.valueOf(String.valueOf(resultData.get("latitude")));
                MongoDistrictCoordinates msd = new MongoDistrictCoordinates(sw.getState(), sw.getDistrict(), latitude, longitude);
                districtCoordinatesMongoRepo.save(msd);
            } else {
                MongoStateCoordinates msd = new MongoStateCoordinates(sw.getState(), (double) 0, (double) 0);
                stateCoordinatesMongoRepo.save(msd);
            }
        }
    }

    public void getNewsData() throws ParseException {
        newsAPIMongoRepository.deleteAll();
        List<MongoCasesStateWise> casesStateWises = stateWiseMongoRepository.findAll();
        for (MongoCasesStateWise csw : casesStateWises.subList(1, casesStateWises.size() - 1)) {
            NewsAPI newsAPI = restTemplate.getForObject("http://newsapi.org/v2/everything?q=covid19 " + csw.getState() + "&from=2021-03-01&sortBy=publishedAt&apiKey=898b8147285c4367a43df902a0196149", NewsAPI.class);

            List<NewsAPI.Article> articles = newsAPI.getArticles();
            List<MongoCovidNews.Articles> mongoCovidArticles = new ArrayList<>();

            for (NewsAPI.Article article : articles) {
                MongoCovidNews.Articles mongoArticle = new MongoCovidNews.Articles();
                mongoArticle.setImgUrl(article.getUrlToImage());
                mongoArticle.setPublishedAt(article.getPublishedDateEpoch());
                mongoArticle.setTitle(article.getTitle());
                mongoArticle.setUrl(article.getUrl());
                mongoArticle.setSourceName(article.getSource().getName());
                mongoCovidArticles.add(mongoArticle);
            }
            MongoCovidNews covidNews = new MongoCovidNews(csw.getState(), mongoCovidArticles);

            newsAPIMongoRepository.save(covidNews);
        }
    }

    private String buildVideoUrl(String videoId) {
        StringBuilder builder = new StringBuilder();
        builder.append("https://www.youtube.com/watch?v=");
        builder.append(videoId);

        return builder.toString();
    }

    private YouTube getYouTube() {
        YouTube youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(),
                (request) -> {
                }).setApplicationName("youtube-spring-boot-demo").build();

        return youtube;
    }

    public void getVideoNewsData() {
        videoNewsMongoRepository.deleteAll();
        List<MongoCasesStateWise> casesStateWises = stateWiseMongoRepository.findAll();
        for (MongoCasesStateWise csw : casesStateWises.subList(1, casesStateWises.size() - 1)) {

            String queryTerm = "Covid 19 " + csw.getState() + " news";
            List<MongoCovidVideoNews.VideoNews> videos = new ArrayList<>();

            try {
                YouTube youtube = getYouTube();

                YouTube.Search.List search = youtube.search().list("id,snippet");

                String apiKey = "AIzaSyBLvPpgBnh8TeRg-JACCuriO6w1fcPEFmw";
                search.setKey(apiKey);

                search.setQ(queryTerm);

                search.setType("video");

                search.setFields("items(id/kind,id/videoId,snippet/title,snippet/description,snippet/publishedAt,snippet/thumbnails/default/url,snippet/channelTitle)");

                search.setMaxResults(MAX_SEARCH_RESULTS);

                DateFormat df = new SimpleDateFormat("MMM dd, yyyy");

                SearchListResponse searchResponse = search.execute();
                List<SearchResult> searchResultList = searchResponse.getItems();
                if (searchResultList != null) {
                    for (SearchResult result : searchResultList) {
                        MongoCovidVideoNews.VideoNews video = new MongoCovidVideoNews.VideoNews();
                        video.setTitle(result.getSnippet().getTitle());
                        video.setUrl(buildVideoUrl(result.getId().getVideoId()));
                        video.setThumbnailUrl(result.getSnippet().getThumbnails().getDefault().getUrl());
                        video.setDescription(result.getSnippet().getDescription());
                        video.setChannelName(result.getSnippet().getChannelTitle());
                        DateTime dateTime = result.getSnippet().getPublishedAt();
                        Date date = new Date(dateTime.getValue());
                        String dateString = df.format(date);
                        video.setPublishDate(dateString);

                        videos.add(video);
                    }
                    MongoCovidVideoNews mongoCovidVideoNews = new MongoCovidVideoNews(csw.getState(), videos);
                    videoNewsMongoRepository.save(mongoCovidVideoNews);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void getGlobalStats(){
        globalStatsMongoRepository.deleteAll();

        GlobalStats globalStats = restTemplate.getForObject(GLOBAL_STATS_URL,GlobalStats.class);
        GlobalStats.Global global = globalStats.getGlobal();
        MongoGlobalStats mongoGlobalStats = new MongoGlobalStats(global.getNewConfirmed(), global.getTotalConfirmed(), global.getNewDeaths(), global.getTotalDeaths(), global.getNewRecovered(), global.getTotalRecovered(), global.getDateEpoch());

        globalStatsMongoRepository.save(mongoGlobalStats);
    }
}
