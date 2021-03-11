package covid19.backend.Configuration;

import covid19.backend.Services.CovidDataSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.text.ParseException;

@Configuration
@EnableScheduling
public class CovidDataSyncConfiguration {

    @Autowired
    CovidDataSyncService dataSyncService;

    @Scheduled(cron = "0 0 21 * * *", zone = "GMT+5:30")
    public void syncLatestData() throws Exception {
        dataSyncService.getNewsData();
    }

    public void syncCoordinates() throws IOException {
        dataSyncService.getStateCoordinates();
        dataSyncService.getDistrictCoordinates();
    }

    public void syncAllData() throws Exception {
        dataSyncService.getDataStateWise();
        dataSyncService.getDataNation();
        dataSyncService.getDataDistrictWise();
    }

    public void syncNewsData() throws ParseException {
        dataSyncService.getNewsData();
        dataSyncService.getVideoNewsData();
    }
}
