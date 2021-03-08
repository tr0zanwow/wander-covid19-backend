package covid19.backend.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class CovidDataSyncConfiguration {

    @Scheduled(cron = "0 57 21 * * *", zone = "GMT+5:30")
    public void syncCovidData() {
    }
}
